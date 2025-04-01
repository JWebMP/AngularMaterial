package com.jwebmp.plugins.angular.material.dialog;

import com.jwebmp.core.base.angular.client.annotations.references.NgImportModule;
import com.jwebmp.core.base.angular.client.annotations.references.NgImportReference;
import com.jwebmp.core.base.angular.client.services.interfaces.INgComponent;
import com.jwebmp.core.base.html.DivSimple;

import java.util.Set;

@NgImportReference(value = "MatDialogActions", reference = "@angular/material/dialog")
@NgImportModule("MatDialogActions")
public class MatDialogActions extends DivSimple<MatDialogActions> implements INgComponent<MatDialogActions>
{
    public MatDialogActions()
    {
        addAttribute("mat-dialog-actions", "");
    }
}
