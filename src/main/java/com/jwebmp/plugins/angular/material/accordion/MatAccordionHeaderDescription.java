package com.jwebmp.plugins.angular.material.accordion;


import com.jwebmp.core.base.html.DivSimple;
import com.jwebmp.plugins.angular.material.accordion.interfaces.MatAccordionHeaderChildren;

public class MatAccordionHeaderDescription extends DivSimple<MatAccordionHeaderDescription> implements
                                                                                            MatAccordionHeaderChildren
{
    public MatAccordionHeaderDescription()
    {
        setTag("mat-panel-description");

    }


}
