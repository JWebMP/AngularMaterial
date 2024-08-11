package com.jwebmp.plugins.angular.material.forms;

import com.jwebmp.plugins.angular.material.formfield.MatFormFieldChildren;

public class MatInputNative extends MatInput<MatInputNative> implements MatInputType, MatFormFieldChildren
{

    @Override
    public void init()
    {
        removeAttribute("matInput ");
        addAttribute("matNativeControl", "");
        super.init();
    }
}
