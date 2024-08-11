package com.jwebmp.plugins.angular.material.accordion;


import com.jwebmp.core.base.html.Div;
import com.jwebmp.core.base.html.attributes.NoAttributes;
import com.jwebmp.core.base.html.interfaces.GlobalFeatures;
import com.jwebmp.core.base.html.interfaces.events.GlobalEvents;
import com.jwebmp.plugins.angular.material.accordion.interfaces.MatAccordionHeaderChildren;
import com.jwebmp.plugins.angular.material.accordion.interfaces.MatAccordionPanelChildren;

public class MatAccordionHeader extends Div<MatAccordionHeaderChildren, NoAttributes, GlobalFeatures, GlobalEvents, MatAccordionHeader> implements
                                                                                                                                        MatAccordionPanelChildren
{
    public MatAccordionHeader()
    {
        setTag("mat-expansion-panel-header");

    }


}
