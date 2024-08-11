package com.jwebmp.plugins.angular.material.table;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.guicedee.client.IGuiceContext;
import com.jwebmp.core.base.angular.client.annotations.references.NgImportReference;
import com.jwebmp.core.base.angular.client.annotations.structures.NgMethod;
import com.jwebmp.core.base.angular.client.services.interfaces.INgComponent;
import com.jwebmp.core.base.html.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static com.guicedee.guicedinjection.interfaces.ObjectBinderKeys.JSONObjectWriter;

@NgImportReference(value = "MatTableModule", reference = "@angular/material/table")
@NgImportReference(value = "MatTable", reference = "@angular/material/table")
@NgImportReference(value = "MatSort", reference = "@angular/material/sort")
@NgImportReference(value = "MatPaginator", reference = "@angular/material/paginator")
@NgImportReference(value = "MatPaginatorModule", reference = "@angular/material/paginator")
@NgImportReference(value = "MatSortModule", reference = "@angular/material/sort")
@NgImportReference(value = "MatTableDataSource", reference = "@angular/material/table")
@Getter
@Setter
@Accessors(chain = true)

@NgMethod("""
        applyFilter(event: Event) {
            const filterValue = (event.target as HTMLInputElement).value;
            this.dataSource.filter = filterValue.trim().toLowerCase();
          }
        """)
public class MatTable extends Table<MatTable> implements INgComponent<MatTable>
{
    private String dataSource;
    private List<MatTableColumn> columns = new ArrayList<>();
    private List<String> columnOrder = new ArrayList<>();

    private MatTableHeaderRow headerRow = new MatTableHeaderRow();
    private MatTableRow tableRow = new MatTableRow();


    public MatTable()
    {
        addAttribute("mat-table", "");
    }

    @Override
    public Set<String> importModules()
    {
        Set<String> strings = INgComponent.super.importModules();
        strings.add("MatTableModule");
        strings.add("MatPaginatorModule");
        strings.add("MatSortModule");
        return strings;
    }

    @Override
    public List<String> fields()
    {
        List<String> fields = INgComponent.super.fields();
        if (columnOrder != null && !columnOrder.isEmpty())
        {
            String rendered = null;
            if (IGuiceContext.getContext()
                             .isBuildingInjector())
            {
                try
                {
                    rendered = new ObjectMapper().writeValueAsString(columnOrder)
                                                 .replace("\r\n", "\n");
                }
                catch (JsonProcessingException e)
                {
                    throw new RuntimeException(e);
                }
            }
            else
            {
                ObjectWriter writer = IGuiceContext.get(JSONObjectWriter);
                try
                {
                    rendered = writer.writeValueAsString(columnOrder);
                }
                catch (JsonProcessingException e)
                {
                    throw new RuntimeException(e);
                }
            }
            fields.add("displayedColumns: string[] = " + rendered + ";");
        }

        if (this.dataSource != null)
        {
            fields.add(" dataSource: MatTableDataSource<any>;");
        }

        return fields;
    }

    @Override
    public List<String> constructorBody()
    {
        List<String> strings = INgComponent.super.constructorBody();
        strings.add("this.dataSource = new MatTableDataSource(this." + dataSource + ");");
        return strings;
    }

    @Override
    public void init()
    {
        if (this.dataSource != null)
        {
            addAttribute("[dataSource]", "dataSource");
        }
        if (columns != null && !columns.isEmpty())
        {
            for (MatTableColumn column : columns)
            {
                add(column);
                if (column.isSort())
                {
                    addAttribute("matSort", "");
                }
            }
        }
        if (headerRow != null)
        {
            add(headerRow);
        }
        if (tableRow != null)
        {
            add(tableRow);
        }
        super.init();
    }

    /**
     * Adds the column and iterates the column position in the column order definition
     *
     * @param column
     * @return this
     */
    public MatTable addColumn(MatTableColumn column)
    {
        columns.add(column);
        columnOrder.add(column.getColumnDef());
        return this;
    }

}
