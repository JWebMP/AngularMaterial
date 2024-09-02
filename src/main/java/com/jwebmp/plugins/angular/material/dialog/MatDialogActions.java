package com.jwebmp.plugins.angular.material.dialog;

import com.jwebmp.core.base.angular.client.annotations.references.NgImportReference;
import com.jwebmp.core.base.angular.client.services.interfaces.INgComponent;
import com.jwebmp.core.base.html.DivSimple;

import java.util.Set;

@NgImportReference(value = "MatDialogActions", reference = "@angular/material/dialog")
public class MatDialogActions extends DivSimple<MatDialogActions> implements INgComponent<MatDialogActions>
{
    @Override
    public Set<String> moduleImports()
    {
        Set<String> strings = INgComponent.super.moduleImports();
        strings.add("MatDialogActions");
        return strings;
    }


    public MatDialogActions()
    {
        addAttribute("mat-dialog-actions", "");
    }
}
