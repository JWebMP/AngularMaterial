package com.jwebmp.plugins.angular.material.accordion;

import com.jwebmp.core.base.angular.client.annotations.references.NgImportReference;
import com.jwebmp.core.base.angular.client.services.interfaces.INgComponent;
import com.jwebmp.core.base.html.Div;
import com.jwebmp.core.base.html.attributes.NoAttributes;
import com.jwebmp.core.base.html.interfaces.GlobalFeatures;
import com.jwebmp.core.base.html.interfaces.events.GlobalEvents;
import com.jwebmp.plugins.angular.material.accordion.interfaces.MatAccordionChildren;
import com.jwebmp.plugins.angular.material.accordion.interfaces.MatAccordionPanelChildren;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NgImportReference(value = "MatExpansionModule", reference = "@angular/material/expansion")
public class MatAccordionPanel extends Div<MatAccordionPanelChildren, NoAttributes, GlobalFeatures, GlobalEvents, MatAccordionPanel> implements
                                                                                                                                     INgComponent<MatAccordionPanel>,
                                                                                                                                     MatAccordionChildren
{
    private MatAccordionExpansionState expansionState;

    private Boolean disabled;
    private Boolean expanded;
    private Boolean hideToggle;
    private MatAccordionTogglePosition togglePosition;

    public MatAccordionPanel()
    {
        setTag("mat-expansion-panel");
    }

    @Override
    protected void init()
    {
        if (disabled != null)
        {
            addAttribute("disabled", "");
        }
        if (expanded != null)
        {
            addAttribute("expanded", "");
        }
        if (hideToggle != null)
        {
            addAttribute("hideToggle", "");
        }
        if (togglePosition != null)
        {
            addAttribute("togglePosition", togglePosition.toString());
        }

        super.init();
    }

    @Override
    public Set<String> moduleImports()
    {
        Set<String> strings = INgComponent.super.moduleImports();
        strings.add("MatExpansionModule");
        return strings;
    }


}
