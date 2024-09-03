package com.jwebmp.plugins.angular.material.autocomplete;

import com.jwebmp.core.base.angular.client.annotations.references.NgImportReference;
import com.jwebmp.core.base.angular.client.services.interfaces.IComponent;
import com.jwebmp.core.base.angular.client.services.interfaces.INgComponent;
import com.jwebmp.core.base.angular.client.services.interfaces.INgServiceProvider;
import com.jwebmp.core.base.angular.components.NgFor;
import com.jwebmp.core.base.html.DivSimple;
import com.jwebmp.plugins.angular.material.formfield.MatFormFieldChildren;
import com.jwebmp.plugins.angular.material.select.MatOption;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

import static com.jwebmp.core.base.angular.client.services.interfaces.AnnotationUtils.getNgComponentReference;
import static com.jwebmp.core.base.angular.client.services.interfaces.AnnotationUtils.getNgField;


@NgImportReference(value = "COMMA", reference = "@angular/cdk/keycodes")
@NgImportReference(value = "ENTER", reference = "@angular/cdk/keycodes")
@NgImportReference(value = "MatAutocomplete", reference = "@angular/material/autocomplete")
@NgImportReference(value = "MatAutocompleteSelectedEvent", reference = "@angular/material/autocomplete")
@Getter
@Setter
public class MatAutoComplete extends DivSimple<MatAutoComplete> implements INgComponent<MatAutoComplete>,
                                                                           MatFormFieldChildren
{
    private MatOption optionTemplate = new MatOption();
    private NgFor ngFor = new NgFor();

    private INgServiceProvider<?> dataProvider;

    private Set<String> separatorKeyCodes = new LinkedHashSet<>(Set.of("ENTER", "COMMA"));

    public MatAutoComplete()
    {
        setTag("mat-autocomplete");
    }

    @Override
    public Set<String> moduleImports()
    {
        var s = INgComponent.super.moduleImports();
        s.add("MatAutocomplete");
        return s;
    }

    public MatAutoComplete(String name)
    {
        this();
        setName(name);
    }

    public MatAutoComplete(String name, INgServiceProvider<?> dataProvider)
    {
        this(name);
        this.dataProvider = dataProvider;
    }

    @Override
    protected void init()
    {
        if (!isInitialized())
        {
            ngFor.add(optionTemplate);
            ngFor.setVariableName("element")
                 .setList(dataProvider.getAnnotation()
                                      .referenceName() + "." + dataProvider.getAnnotation()
                                                                           .variableName());
            ngFor.setTrackBy("$index");
            add(ngFor);

            addAttribute("#" + getName(), "");

            if (this.dataProvider != null)
            {
                addConfiguration(getNgComponentReference((Class<? extends IComponent<?>>) dataProvider.getClass()));
                addConfiguration(getNgField("readonly separatorKeysCodes: number[] = " + separatorKeyCodes.toString() + ";"));

                ;//ngFor.setVariableName("")
            }
        }
        super.init();
    }
}
