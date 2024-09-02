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
@NgImportReference(value = "MatFormField", reference = "@angular/material/form-field")
@NgImportReference(value = "MatLabel", reference = "@angular/material/form-field")
@NgImportReference(value = "MatInput", reference = "@angular/material/input")
@NgImportReference(value = "FormsModule", reference = "@angular/forms")

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
    public Set<String> moduleImports()
    {
        Set<String> strings = INgComponent.super.moduleImports();
        strings.add("MatFormField");
        strings.add("MatLabel");
        strings.add("MatInput");
        strings.add("FormsModule");
        return strings;
    }

    @Override
    protected void init()
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

    public MatFormField setLabel(String label)
    {
        this.label = new MatLabel(label);
        return this;
    }

    public MatFormField setLabel(MatLabel label)
    {
        this.label = label;
        return this;
    }

    public MatFormField setHint(String hint)
    {
        this.hint = new MatHint().setText(hint);
        return this;
    }

    public MatFormField setHint(MatHint hint)
    {
        this.hint = hint;
        return this;
    }
}
