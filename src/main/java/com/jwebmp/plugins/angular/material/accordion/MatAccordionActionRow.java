package com.jwebmp.plugins.angular.material.accordion;

import com.jwebmp.core.base.html.DivSimple;
import com.jwebmp.plugins.angular.material.accordion.interfaces.MatAccordionPanelChildren;

public class MatAccordionActionRow extends DivSimple<MatAccordionActionRow> implements MatAccordionPanelChildren
{
    public MatAccordionActionRow()
    {
        setTag("mat-action-row");
    }
}
