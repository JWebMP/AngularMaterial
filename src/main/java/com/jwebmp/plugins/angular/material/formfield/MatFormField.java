package com.jwebmp.plugins.angular.material.formfield;

import com.jwebmp.core.base.angular.client.annotations.references.NgImportReference;
import com.jwebmp.core.base.angular.client.services.interfaces.INgComponent;
import com.jwebmp.core.base.html.Div;
import com.jwebmp.core.base.html.attributes.NoAttributes;
import com.jwebmp.core.base.html.interfaces.GlobalFeatures;
import com.jwebmp.core.base.html.interfaces.events.GlobalEvents;
import com.jwebmp.core.base.interfaces.IComponentHierarchyBase;
import com.jwebmp.plugins.angular.material.forms.MatInputType;
import com.jwebmp.plugins.angular.material.forms.MatLabel;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NgImportReference(value = "MatFormFieldModule", reference = "@angular/material/form-field")
public class MatFormField extends Div<MatFormFieldChildren, NoAttributes, GlobalFeatures, GlobalEvents, MatFormField> implements
                                                                                                                      INgComponent<MatFormField>
{
    private boolean outline;

    private MatLabel label;
    private MatInputType input;
    private MatHint hint;

    private List<MatFormFieldChildren> suffixes = new ArrayList<>();

    public MatFormField()
    {
        setTag("mat-form-field");
    }

    @Override
    public Set<String> importModules()
    {
        Set<String> strings = INgComponent.super.importModules();
        strings.add("MatFormFieldModule");
        return strings;
    }

    @Override
    public void init()
    {
        if (label != null)
        {
            add(label);
        }
        if (input != null)
        {
            add(input);
        }
        if (suffixes != null && !suffixes.isEmpty())
        {
            for (MatFormFieldChildren suffix : suffixes)
            {
                IComponentHierarchyBase<?, ?> suffixs = (IComponentHierarchyBase<?, ?>) suffix;
                suffixs.asAttributeBase()
                       .addAttribute("matSuffix", "");
                add(suffix);
            }
        }
        if (hint != null)
        {
            add(hint);
        }
        if (outline)
        {
            addAttribute("appearance", "outline");
        }
        else
        {
            addAttribute("appearance", "fill");
        }
        super.init();
    }

    public MatFormField addSuffix(MatFormFieldChildren component)
    {
        suffixes.add(component);
        return this;
    }
}
