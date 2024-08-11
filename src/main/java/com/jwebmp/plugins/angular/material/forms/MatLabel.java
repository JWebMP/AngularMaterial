package com.jwebmp.plugins.angular.material.forms;

import com.jwebmp.core.base.html.DivSimple;
import com.jwebmp.plugins.angular.material.formfield.MatFormFieldChildren;

public class MatLabel extends DivSimple<MatLabel> implements MatFormFieldChildren
{
    public MatLabel()
    {
        setTag("mat-label");
    }
}
