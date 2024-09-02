package com.jwebmp.plugins.angular.material.accordion;

import com.jwebmp.core.base.angular.client.annotations.references.NgImportReference;
import com.jwebmp.core.base.angular.client.annotations.structures.NgField;
import com.jwebmp.core.base.angular.client.services.interfaces.INgComponent;
import com.jwebmp.core.base.html.Div;
import com.jwebmp.core.base.html.attributes.NoAttributes;
import com.jwebmp.core.base.html.interfaces.GlobalFeatures;
import com.jwebmp.core.base.html.interfaces.events.GlobalEvents;
import com.jwebmp.plugins.angular.material.accordion.interfaces.MatAccordionChildren;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NgImportReference(value = "MatAccordion", reference = "@angular/material/expansion")
@NgImportReference(value = "viewChild", reference = "@angular/core")
@NgField("accordion = viewChild.required(MatAccordion)")
@NgImportReference(value = "MatExpansionModule", reference = "@angular/material/expansion")
public class MatAccordion extends Div<MatAccordionChildren, NoAttributes, GlobalFeatures, GlobalEvents, MatAccordion> implements
                                                                                                                      INgComponent<MatAccordion>
{
    private MatAccordionTogglePosition togglePosition;
    private MatAccordionDisplayMode displayMode;

    private Boolean multi;
    private Boolean hideToggle;

    public MatAccordion()
    {
        setTag("mat-accordion");
    }

    @Override
    protected void init()
    {
        if (togglePosition != null)
        {
            addAttribute("togglePosition", togglePosition + "");
        }
        if (displayMode != null)
        {
            addAttribute("displayMode", displayMode + "");
        }
        if (hideToggle != null)
        {
            addAttribute("hideToggle", hideToggle + "");
        }
        if (multi != null)
        {
            addAttribute("multi", multi + "");
        }
        super.init();
    }

    @Override
    public Set<String> moduleImports()
    {
        Set<String> strings = INgComponent.super.moduleImports();
        strings.add("MatAccordion");
        strings.add("MatExpansionModule");
        return strings;
    }

    @Override
    public Boolean standaloneOverride()
    {
        return true;
    }
}
