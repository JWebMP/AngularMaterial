package com.jwebmp.plugins.angular.material.select;

import com.jwebmp.core.base.angular.client.annotations.references.NgImportModule;
import com.jwebmp.core.base.angular.client.annotations.references.NgImportReference;
import com.jwebmp.core.base.angular.client.services.interfaces.INgComponent;
import com.jwebmp.core.base.html.Div;
import com.jwebmp.core.base.html.attributes.NoAttributes;
import com.jwebmp.core.base.html.interfaces.GlobalFeatures;
import com.jwebmp.core.base.html.interfaces.events.GlobalEvents;
import com.jwebmp.plugins.angular.material.formfield.MatFormFieldChildren;
import com.jwebmp.plugins.angular.material.forms.MatInputType;
import lombok.Getter;

import java.util.Set;

@NgImportReference(value = "MatSelectModule", reference = "@angular/material/select")
@Getter
@NgImportModule("MatSelectModule")
public class MatSelect<J extends MatSelect<J>> extends Div<MatSelectChildren, NoAttributes, GlobalFeatures, GlobalEvents, J> implements
        INgComponent<J>,
        MatFormFieldChildren,
        MatInputType
{
    private Boolean disableOptionCentering;
    private Boolean disableRipple;
    private Boolean disabled;
    private String errorStateMatcher;
    private Boolean hideSingleSelectionIndicator;
    private Boolean multiple;
    private String panelWidth;
    private String placeHolder;
    private Boolean required;
    private Boolean focused;
    private String name;

    public MatSelect()
    {
        setTag("mat-select");
    }

    public MatSelect(String name)
    {
        this();
        setName(name);
    }

    @SuppressWarnings("unchecked")
    public J setDisableOptionCentering(Boolean disableOptionCentering) { this.disableOptionCentering = disableOptionCentering; return (J) this; }
    @SuppressWarnings("unchecked")
    public J setDisableRipple(Boolean disableRipple) { this.disableRipple = disableRipple; return (J) this; }
    @SuppressWarnings("unchecked")
    public J setDisabled(Boolean disabled) { this.disabled = disabled; return (J) this; }
    @SuppressWarnings("unchecked")
    public J setErrorStateMatcher(String errorStateMatcher) { this.errorStateMatcher = errorStateMatcher; return (J) this; }
    @SuppressWarnings("unchecked")
    public J setHideSingleSelectionIndicator(Boolean hideSingleSelectionIndicator) { this.hideSingleSelectionIndicator = hideSingleSelectionIndicator; return (J) this; }
    @SuppressWarnings("unchecked")
    public J setMultiple(Boolean multiple) { this.multiple = multiple; return (J) this; }
    @SuppressWarnings("unchecked")
    public J setPanelWidth(String panelWidth) { this.panelWidth = panelWidth; return (J) this; }
    @SuppressWarnings("unchecked")
    public J setPlaceHolder(String placeHolder) { this.placeHolder = placeHolder; return (J) this; }
    @SuppressWarnings("unchecked")
    public J setRequired(Boolean required) { this.required = required; return (J) this; }
    @SuppressWarnings("unchecked")
    public J setFocused(Boolean focused) { this.focused = focused; return (J) this; }
    @SuppressWarnings("unchecked")
    public J setName(String name) { this.name = name; return (J) this; }

    @Override
    protected void init()
    {
        if (disableOptionCentering != null)
        {
            addAttribute("disableOptionCentering", disableOptionCentering + "");
        }
        if (disableRipple != null)
        {
            addAttribute("disableRipple", disableRipple + "");
        }
        if (disabled != null)
        {
            addAttribute("disabled", disabled + "");
        }
        if (hideSingleSelectionIndicator != null)
        {
            addAttribute("hideSingleSelectionIndicator", hideSingleSelectionIndicator + "");
        }
        if (multiple != null)
        {
            addAttribute("multiple", multiple + "");
        }
        if (panelWidth != null)
        {
            addAttribute("panelWidth", panelWidth + "");
        }
        if (placeHolder != null)
        {
            addAttribute("placeHolder", placeHolder + "");
        }
        if (required != null)
        {
            addAttribute("required", required + "");
        }
        if (focused != null)
        {
            addAttribute("focused", focused + "");
        }
        super.init();
    }
    
    @Override
    @SuppressWarnings("unchecked")
    public J bind(String variableName)
    {
        addAttribute("[(value)]", variableName);
        return (J) this;
    }

    @Override
    public Boolean standaloneOverride()
    {
        return true;
    }

}
