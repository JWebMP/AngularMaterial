package com.jwebmp.plugins.angular.material.formfield;

import com.jwebmp.core.base.angular.client.annotations.references.NgImportModule;
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

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Getter
@NgImportReference(value = "MatFormField", reference = "@angular/material/form-field")
@NgImportReference(value = "MatLabel", reference = "@angular/material/form-field")
@NgImportReference(value = "MatInput", reference = "@angular/material/input")
@NgImportReference(value = "FormsModule", reference = "@angular/forms")
@NgImportModule("MatFormField")
@NgImportModule("MatLabel")
@NgImportModule("MatInput")
@NgImportModule("FormsModule")
public class MatFormField<J extends MatFormField<J>> extends Div<MatFormFieldChildren, NoAttributes, GlobalFeatures, GlobalEvents, J> implements
        INgComponent<J>
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

    @SuppressWarnings("unchecked")
    public J addSuffix(MatFormFieldChildren component)
    {
        suffixes.add(component);
        return (J) this;
    }

    @SuppressWarnings("unchecked")
    public J setLabel(String label)
    {
        this.label = new MatLabel(label);
        return (J) this;
    }

    @SuppressWarnings("unchecked")
    public J setLabel(MatLabel label)
    {
        this.label = label;
        return (J) this;
    }

    @SuppressWarnings("unchecked")
    public J setHint(String hint)
    {
        this.hint = new MatHint().setText(hint);
        return (J) this;
    }

    @SuppressWarnings("unchecked")
    public J setHint(MatHint hint)
    {
        this.hint = hint;
        return (J) this;
    }

    @SuppressWarnings("unchecked")
    public J setOutline(boolean outline)
    {
        this.outline = outline;
        return (J) this;
    }

    @SuppressWarnings("unchecked")
    public J setInput(MatInputType input)
    {
        this.input = input;
        return (J) this;
    }

    @SuppressWarnings("unchecked")
    public J setSuffixes(List<MatFormFieldChildren> suffixes)
    {
        this.suffixes = suffixes;
        return (J) this;
    }
}
