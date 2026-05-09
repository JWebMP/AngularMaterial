package com.jwebmp.plugins.angular.material.table;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.guicedee.modules.services.jsonrepresentation.IJsonRepresentation;
import com.jwebmp.core.base.angular.client.annotations.references.NgImportModule;
import com.jwebmp.core.base.angular.client.annotations.references.NgImportReference;
import com.jwebmp.core.base.angular.client.services.interfaces.INgComponent;
import com.jwebmp.core.base.html.DivSimple;
import com.jwebmp.core.base.html.interfaces.children.TableChildren;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Getter
@NgImportReference(value = "MatPaginator", reference = "@angular/material/paginator")
@NgImportModule("MatPaginator")
public class MatTablePaginator<J extends MatTablePaginator<J>> extends DivSimple<J> implements TableChildren,
        INgComponent<J>
{
    private List<Integer> pageSizeOptions;
    private Boolean showFirstLastButtons;

    public MatTablePaginator()
    {
        setTag("mat-paginator");
    }

    @SuppressWarnings("unchecked")
    public J setPageSizeOptions(List<Integer> pageSizeOptions)
    {
        this.pageSizeOptions = pageSizeOptions;
        return (J) this;
    }

    @SuppressWarnings("unchecked")
    public J setShowFirstLastButtons(Boolean showFirstLastButtons)
    {
        this.showFirstLastButtons = showFirstLastButtons;
        return (J) this;
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
