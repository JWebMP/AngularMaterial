package com.jwebmp.plugins.angular.material.dialog;

import com.jwebmp.core.base.angular.client.annotations.references.NgImportModule;
import com.jwebmp.core.base.angular.client.annotations.references.NgImportReference;
import com.jwebmp.core.base.html.DivSimple;

@NgImportReference(value = "MatDialogContent", reference = "@angular/material/dialog")
@NgImportModule("MatDialogContent")
public class MatDialogContent extends DivSimple<MatDialogContent>
{
    public MatDialogContent()
    {
        addAttribute("mat-dialog-content", "");
    }
}
