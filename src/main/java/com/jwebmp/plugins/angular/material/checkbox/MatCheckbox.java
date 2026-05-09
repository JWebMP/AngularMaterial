package com.jwebmp.plugins.angular.material.checkbox;

import com.jwebmp.core.base.angular.client.annotations.references.NgImportModule;
import com.jwebmp.core.base.angular.client.annotations.references.NgImportReference;
import com.jwebmp.core.base.angular.client.services.interfaces.INgComponent;
import com.jwebmp.core.base.html.DivSimple;
import com.jwebmp.plugins.angular.material.formfield.MatFormFieldChildren;
import com.jwebmp.plugins.angular.material.forms.MatInputType;
import lombok.Getter;

@NgImportReference(value = "MatCheckboxModule", reference = "@angular/material/checkbox")
@NgImportReference(value = "MatCheckboxChange", reference = "@angular/material/checkbox")
@Getter
@NgImportModule("MatCheckboxModule")
public class MatCheckbox<J extends MatCheckbox<J>> extends DivSimple<J> implements INgComponent<J>, MatFormFieldChildren,
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
    @SuppressWarnings("unchecked")
    public J bind(String variableName)
    {
        super.bind(variableName);
        addAttribute("[checked]", variableName);
        return (J) this;
    }

    @SuppressWarnings("unchecked")
    public J setChecked(Boolean checked) { this.checked = checked; return (J) this; }
    @SuppressWarnings("unchecked")
    public J setColor(String color) { this.color = color; return (J) this; }
    @SuppressWarnings("unchecked")
    public J setDisableRipple(Boolean disableRipple) { this.disableRipple = disableRipple; return (J) this; }
    @SuppressWarnings("unchecked")
    public J setIndeterminate(Boolean indeterminate) { this.indeterminate = indeterminate; return (J) this; }
    @SuppressWarnings("unchecked")
    public J setLabelPosition(MatCheckboxLabelPosition labelPosition) { this.labelPosition = labelPosition; return (J) this; }
    @SuppressWarnings("unchecked")
    public J setName(String name) { this.name = name; return (J) this; }
    @SuppressWarnings("unchecked")
    public J setRequired(Boolean required) { this.required = required; return (J) this; }
    @SuppressWarnings("unchecked")
    public J setValue(String value) { this.value = value; return (J) this; }

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
    public Boolean standaloneOverride()
    {
        return true;
    }
}
