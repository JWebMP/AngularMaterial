package com.jwebmp.plugins.angular.material.forms;

import com.jwebmp.core.base.angular.client.annotations.references.NgImportReference;
import com.jwebmp.core.base.angular.client.services.interfaces.INgComponent;
import com.jwebmp.core.base.html.Input;
import com.jwebmp.core.base.html.attributes.InputAttributes;
import com.jwebmp.plugins.angular.material.formfield.MatFormFieldChildren;

import java.util.Set;

@NgImportReference(value = "MatInputModule", reference = "@angular/material/input")
public class MatInput<J extends MatInput<J>> extends Input<InputAttributes, J> implements INgComponent<J>,
                                                                                          MatFormFieldChildren,
                                                                                          MatInputType
{

    public MatInput()
    {
        addAttribute("matInput", "");
    }

    @Override
    protected void init()
    {
        super.init();
    }

    @Override
    public Set<String> moduleImports()
    {
        Set<String> strings = INgComponent.super.moduleImports();
        strings.add("MatInputModule");
        return strings;
    }

}
