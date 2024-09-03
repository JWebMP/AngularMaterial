package com.jwebmp.plugins.angular.material.chips;

import com.jwebmp.core.base.angular.client.annotations.references.NgImportReference;
import com.jwebmp.core.base.angular.client.annotations.structures.NgMethod;
import com.jwebmp.core.base.html.Button;
import com.jwebmp.plugins.angular.material.MatIcon;
import com.jwebmp.plugins.angular.material.autocomplete.MatAutoComplete;
import com.jwebmp.plugins.angular.material.formfield.MatFormField;
import com.jwebmp.plugins.angular.material.forms.MatInput;
import com.jwebmp.plugins.angular.material.forms.MatLabel;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

import static com.jwebmp.core.base.angular.client.services.interfaces.AnnotationUtils.getNgField;

@Getter
@Setter
@NgImportReference(value = "MatAutocompleteTrigger", reference = "@angular/material/autocomplete")
@NgImportReference(value = "MatChipInputEvent", reference = "@angular/material/chips")
@NgImportReference(value = "signal", reference = "@angular/core")
@NgImportReference(value = "model", reference = "@angular/core")
@NgImportReference(value = "computed", reference = "@angular/core")
@NgMethod("""
         add(event: MatChipInputEvent): void {
                 const value = (event.value || {});
        
                 // Add our fruit
                 if (value) {
                     this.selected.update((selecteds: any) => [...selecteds, this.staffList.staff.filter(a => a.id === value)][0]);
                 }
             }
        """)
@NgMethod("""
             remove(selected: any): void {
                     this.selected.update((selecteds: any) => {
                         const index = selecteds.indexOf(selected);
                         if (index < 0) {
                             return selecteds;
                         }
        
                         selecteds.splice(index, 1);
                         //this.announcer.announce(`Removed ${selected}`);
                         return [...selecteds];
                     });
                 }
        """)
@NgMethod("""
        chosen(event: MatAutocompleteSelectedEvent): void {
              //  debugger
                this.selected.update((me: any)=>[...me,event.option.value] as any)
                this.staffTimesheetCreateData.timesheet.staffIds.push(event.option.value.id);
                //this.currentSelected.set('');
                event.option.deselect();
            }
        """)
public class MatChipAutoComplete extends MatFormField
{
    private MatLabel label;
    private MatChipGrid grid;
    private MatInput<?> input;
    private MatAutoComplete autoComplete;

    @Override
    public Set<String> moduleImports()
    {
        Set<String> strings = super.moduleImports();
        strings.add("MatAutocompleteTrigger");
        return strings;
    }


    public MatChipAutoComplete()
    {
        grid = new MatChipGrid();
        grid.getRowTemplate()
            .addAttribute("(removed)", "remove(element)");
        Button removeButton = new Button<>();
        removeButton.addAttribute("matChipRemove", "");
        removeButton.addAttribute("[attr.aria-label]", "'remove ' + element");
        removeButton.add(new MatIcon().setIcon("cancel"));
        grid.getRowTemplate()
            .add(removeButton);
    }

    @Override
    protected void init()
    {
        if (!isInitialized())
        {
            if (label != null)
            {
                add(label);
            }
            if (grid != null)
            {
                add(grid);
            }
            if (input != null)
            {
                input.bind("selectedItem");
                input.setName("chipInput");
                input.addAttribute("[matChipInputSeparatorKeyCodes]", "separatorKeysCodes");
                add(input);
            }
            if (autoComplete != null)
            {
                add(autoComplete);
                autoComplete.addAttribute("(optionSelected)", "chosen($event)");
            }
            if (input != null && grid != null)
            {
                input.addAttribute("[matChipInputFor]", grid.getName());
            }
            if (input != null && autoComplete != null)
            {

                //addConfiguration(getNgField(" readonly selectedItems = signal(this.staffTimesheetCreateData.timesheet.staffIds);"));
                addConfiguration(getNgField("readonly selectedItem = model({} as any);"));
                addConfiguration(getNgField("readonly selected = signal([] as any);"));
                addConfiguration(getNgField("readonly filtered = computed(() => {\n" +
                                                    "\t\tconst current = this.selectedItem();\n" +
                                                    "\t\treturn current\n" +
                                                    "\t\t\t? this.staffList.staff.filter(item => item.id !==current.id)\n" +
                                                    "\t\t\t: this.staffList.staff.slice();\n" +
                                                    "\t});"));

                input.addAttribute("[matAutocomplete]", autoComplete.getName());
                input.addAttribute("(matChipInputTokenEnd)", "add($event)");
            }
        }
        super.init();
    }
}
