package com.jwebmp.plugins.angular.material.checkbox;

import com.jwebmp.core.base.angular.client.annotations.references.NgImportReference;
import com.jwebmp.core.base.angular.client.services.interfaces.INgComponent;
import com.jwebmp.core.base.html.DivSimple;
import com.jwebmp.plugins.angular.material.formfield.MatFormFieldChildren;
import com.jwebmp.plugins.angular.material.forms.MatInputType;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@NgImportReference(value = "MatCheckboxModule", reference = "@angular/material/checkbox")
@Getter
@Setter
public class MatCheckbox extends DivSimple<MatCheckbox> implements INgComponent<MatCheckbox>, MatFormFieldChildren,
                                                                   MatInputType
{
    private Boolean checked;
    private String color;
    private Boolean disableRipple;
    private Boolean indeterminate;
    private MatCheckboxLabelPosition labelPosition;
    private String name;
    private Boolean required;
    private String value;


    public MatCheckbox()
    {
        setTag("mat-checkbox");
    }

    @Override
    protected void init()
    {
        if (checked != null)
        {
            addAttribute("checked", checked + "");
        }
        if (color != null)
        {
            addAttribute("color", color);
        }
        if (disableRipple != null)
        {
            addAttribute("disableRipple", disableRipple + "");
        }
        if (indeterminate != null)
        {
            addAttribute("indeterminate", indeterminate + "");
        }
        if (labelPosition != null)
        {
            addAttribute("labelPosition", labelPosition + "");
        }
        if (name != null)
        {
            addAttribute("name", name);
        }
        if (required != null)
        {
            addAttribute("required", required + "");
        }
        if (value != null)
        {
            addAttribute("value", value);
        }
        super.init();
    }

    @Override
    public Set<String> moduleImports()
    {
        Set<String> strings = INgComponent.super.moduleImports();
        strings.add("MatCheckboxModule");
        return strings;
    }

    @Override
    public Boolean standaloneOverride()
    {
        return true;
    }
}
