package com.jwebmp.plugins.angular.material.select;

import com.jwebmp.core.base.angular.client.annotations.references.NgImportReference;
import com.jwebmp.core.base.angular.client.services.interfaces.INgComponent;
import com.jwebmp.core.base.html.Div;
import com.jwebmp.core.base.html.attributes.NoAttributes;
import com.jwebmp.core.base.html.interfaces.GlobalFeatures;
import com.jwebmp.core.base.html.interfaces.events.GlobalEvents;
import com.jwebmp.plugins.angular.material.formfield.MatFormFieldChildren;
import com.jwebmp.plugins.angular.material.forms.MatInputType;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@NgImportReference(value = "MatSelectModule", reference = "@angular/material/select")
@Getter
@Setter
public class MatSelect extends Div<MatSelectChildren, NoAttributes, GlobalFeatures, GlobalEvents, MatSelect> implements
                                                                                                             INgComponent<MatSelect>,
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
    public Set<String> moduleImports()
    {
        Set<String> strings = INgComponent.super.moduleImports();
        strings.add("MatSelectModule");
        return strings;
    }

    @Override
    public MatSelect bind(String variableName)
    {
        addAttribute("[(value)]", variableName);
        return this;
    }

    @Override
    public Boolean standaloneOverride()
    {
        return true;
    }

}
