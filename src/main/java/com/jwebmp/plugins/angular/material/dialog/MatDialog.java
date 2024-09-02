package com.jwebmp.plugins.angular.material.dialog;

import com.google.common.base.Strings;
import com.jwebmp.core.base.angular.client.annotations.constructors.NgConstructorParameter;
import com.jwebmp.core.base.angular.client.annotations.references.NgImportReference;
import com.jwebmp.core.base.angular.client.annotations.structures.NgMethod;
import com.jwebmp.core.base.angular.client.services.interfaces.AnnotationUtils;
import com.jwebmp.core.base.angular.client.services.interfaces.INgComponent;
import com.jwebmp.core.base.html.DivSimple;
import com.jwebmp.core.base.html.H1;
import com.jwebmp.core.base.interfaces.IComponentHierarchyBase;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;

import static com.jwebmp.core.base.angular.client.services.interfaces.AnnotationUtils.getTsFilename;

@Getter
@Setter

@NgConstructorParameter("public dialogRef: MatDialogRef<any>")
@NgConstructorParameter("@Inject(MAT_DIALOG_DATA) public data: any")

@NgConstructorParameter(value = "public dialog:MatDialog", onParent = true)

@NgImportReference(value = "Inject", reference = "@angular/core")

@NgImportReference(value = "MatDialog", reference = "@angular/material/dialog")
@NgImportReference(value = "MatDialog", reference = "@angular/material/dialog", onParent = true)

@NgImportReference(value = "MatDialogModule", reference = "@angular/material/dialog")
@NgImportReference(value = "MatDialogRef", reference = "@angular/material/dialog")
@NgImportReference(value = "MAT_DIALOG_DATA", reference = "@angular/material/dialog")


@NgMethod("""
            closeDialog(returnedData : any)
                {
                    this.dialogRef.close(returnedData);
                }
        """)

@NgImportReference(value = "MatDialogTitle", reference = "@angular/material/dialog")
@NgImportReference(value = "MatDialogContent", reference = "@angular/material/dialog")
public class MatDialog extends DivSimple<MatDialog> implements INgComponent<MatDialog>
{
    private H1<?> title;
    private MatDialogContent content;
    private MatDialogActions footer;

    @Override
    protected void init()
    {
        if (title != null)
        {
            title.addAttribute("mat-dialog-title", "");
            add(title);
        }
        if (content != null)
        {
            add(content);
        }
        if (footer != null)
        {
            add(footer);
        }
        super.init();
    }

    @Override
    public Boolean standaloneOverride()
    {
        return true;
    }

    @Override
    public Set<String> moduleImports()
    {
        Set<String> strings = INgComponent.super.moduleImports();
        strings.add("MatDialogTitle");
        strings.add("MatDialogContent");
        return strings;
    }

    @Override
    public List<String> providers()
    {
        List<String> providers = INgComponent.super.providers();
     /*   providers.add("{\n" +
                              "       provide: MatDialogRef,\n" +
                              "       useValue: {}\n" +
                              "     }");

        providers.add("{\n" +
                              "       provide: MAT_DIALOG_DATA,\n" +
                              "       useValue: {}\n" +
                              "     }");
*/

        return providers;
    }

    private static final String openMethodString = """
                openDialog(data :any,values:any): void {
                    this.dialog.open(%s, {
                      width: '%s',
                      height: '%s',
                      data : {
                            data : %s,
                            values : values
                       }
                    })%s;
                  }
            """;

    public String renderOpenMethod(IComponentHierarchyBase<?, ?> component, String width, String height, String dataBinding, String performWithResult)
    {

        String format = null;
        if (Strings.isNullOrEmpty(assignResultString))
        {
            format = String.format(openMethodString, getTsFilename(getClass()), width, height, Strings.isNullOrEmpty(dataBinding) ? "{}" : dataBinding, "");
            component.addConfiguration(AnnotationUtils.getNgMethod(format));
        }
        else
        {
            String assign = String.format(assignResultString, performWithResult);
            format = String.format(openMethodString, getTsFilename(getClass()), width, height, Strings.isNullOrEmpty(dataBinding) ? "{}" : dataBinding, assign);

        }
        if (component != null)
        {
            component.addConfiguration(AnnotationUtils.getNgImportReference("MatDialogModule", "@angular/material/dialog"));
            component.addConfiguration(AnnotationUtils.getNgImportModule("MatDialogModule"));
            component.addConfiguration(AnnotationUtils.getNgConstructorParameter("public dialog:MatDialog"));
            component.addConfiguration(AnnotationUtils.getNgMethod(format));
        }
        return format;
    }

    private static final String assignResultString = """
                .afterClosed().subscribe(result => {
                         console.log('The dialog was closed');
                         if (result !== undefined) {
                           %s
                         }
                       })
            """;
}
