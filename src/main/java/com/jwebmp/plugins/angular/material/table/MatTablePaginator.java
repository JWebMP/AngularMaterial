package com.jwebmp.plugins.angular.material.table;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.guicedee.services.jsonrepresentation.IJsonRepresentation;
import com.jwebmp.core.base.angular.client.annotations.references.NgImportReference;
import com.jwebmp.core.base.angular.client.services.interfaces.INgComponent;
import com.jwebmp.core.base.html.DivSimple;
import com.jwebmp.core.base.html.interfaces.children.TableChildren;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@NgImportReference(value = "MatPaginator", reference = "@angular/material/paginator")
public class MatTablePaginator extends DivSimple<MatTablePaginator> implements TableChildren,
                                                                               INgComponent<MatTablePaginator>
{
    private List<Integer> pageSizeOptions;
    private Boolean showFirstLastButtons;

    @Override
    public Set<String> moduleImports()
    {
        Set<String> strings = INgComponent.super.moduleImports();
        strings.add("MatPaginator");
        return strings;
    }


    public MatTablePaginator()
    {
        setTag("mat-paginator");
    }

    @Override
    protected void init()
    {
        if (pageSizeOptions != null)
        {
            try
            {
                addAttribute("[pageSizeOptions]", IJsonRepresentation.getObjectMapper()
                                                                     .writeValueAsString(pageSizeOptions));
            }
            catch (JsonProcessingException e)
            {
                throw new RuntimeException(e);
            }
        }
        if (showFirstLastButtons != null)
        {
            addAttribute("showFirstLastButtons", "");
        }
        super.init();
    }
}
