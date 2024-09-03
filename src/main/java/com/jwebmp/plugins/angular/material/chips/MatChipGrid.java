package com.jwebmp.plugins.angular.material.chips;

import com.google.common.base.Strings;
import com.jwebmp.core.Component;
import com.jwebmp.core.base.angular.client.annotations.references.NgImportReference;
import com.jwebmp.core.base.angular.client.services.interfaces.INgComponent;
import com.jwebmp.core.base.angular.components.NgFor;
import com.jwebmp.core.base.html.attributes.NoAttributes;
import com.jwebmp.core.base.html.interfaces.GlobalChildren;
import com.jwebmp.core.base.html.interfaces.GlobalFeatures;
import com.jwebmp.core.base.html.interfaces.events.GlobalEvents;
import com.jwebmp.plugins.angular.material.formfield.MatFormFieldChildren;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@NgImportReference(value = "MatChipGrid", reference = "@angular/material/chips")
@NgImportReference(value = "MatChipInput", reference = "@angular/material/chips")
@Getter
@Setter
public class MatChipGrid extends Component<GlobalChildren, NoAttributes, GlobalFeatures, GlobalEvents<?>, MatChipGrid> implements
                                                                                                                       INgComponent<MatChipGrid>,
                                                                                                                       MatFormFieldChildren
{
    private String variableName;

    private MatChipRow rowTemplate = new MatChipRow();

    @Override
    public Set<String> moduleImports()
    {
        Set<String> strings = INgComponent.super.moduleImports();
        strings.add("MatChipGrid");
        strings.add("MatChipInput");
        return strings;
    }

    public MatChipGrid()
    {
        setTag("mat-chip-grid");
        addAttribute("#matChipGrid", "");
        setName("matChipGrid");
    }

    @Override
    protected void init()
    {
        if (!isInitialized())
        {
            NgFor ngFor = new NgFor();
            add(ngFor);
            if (!Strings.isNullOrEmpty(variableName))
            {
                ngFor.setVariableName(variableName);
            }
            else
            {
                ngFor.setVariableName("element");
            }
            ngFor.setTrackBy("$index");
            ngFor.setList("selected()");
            ngFor.add(rowTemplate);
        }
        super.init();
    }
}
