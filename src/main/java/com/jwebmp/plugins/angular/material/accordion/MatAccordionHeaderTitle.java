package com.jwebmp.plugins.angular.material.accordion;


import com.jwebmp.core.base.html.DivSimple;
import com.jwebmp.plugins.angular.material.accordion.interfaces.MatAccordionHeaderChildren;

public class MatAccordionHeaderTitle extends DivSimple<MatAccordionHeaderTitle> implements
                                                                                MatAccordionHeaderChildren
{
    public MatAccordionHeaderTitle()
    {
        setTag("mat-panel-title");

    }


}
