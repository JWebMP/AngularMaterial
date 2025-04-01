package com.jwebmp.plugins.angular.material.forms;

import com.jwebmp.core.base.angular.client.annotations.references.NgImportModule;
import com.jwebmp.core.base.angular.client.annotations.references.NgImportReference;
import com.jwebmp.core.base.angular.client.services.interfaces.INgComponent;
import com.jwebmp.core.base.html.Input;
import com.jwebmp.core.base.html.attributes.InputAttributes;
import com.jwebmp.plugins.angular.material.formfield.MatFormFieldChildren;

import java.util.Set;

@NgImportReference(value = "MatInputModule", reference = "@angular/material/input")
@NgImportModule("MatInputModule")
public class MatInput<J extends MatInput<J>> extends Input<InputAttributes, J> implements INgComponent<J>,
        MatFormFieldChildren,
        MatInputType
{

    public MatInput()
    {
        addAttribute("matInput", "");
    }
}
