package com.jwebmp.plugins.angular.material.table;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.guicedee.client.IGuiceContext;
import com.jwebmp.core.base.angular.client.annotations.boot.NgBootImportReference;
import com.jwebmp.core.base.angular.client.annotations.boot.NgBootModuleImport;
import com.jwebmp.core.base.angular.client.annotations.components.NgInput;
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
@NgBootImportReference(value = "MatSort", reference = "@angular/material/sort")
@NgImportReference(value = "MatPaginator", reference = "@angular/material/paginator")
@NgBootImportReference(value = "MatPaginator", reference = "@angular/material/paginator")
@NgBootModuleImport("MatPaginator")
//@NgImportReference(value = "MatPaginatorModule", reference = "@angular/material/paginator")
@NgImportReference(value = "MatSortModule", reference = "@angular/material/sort")
@NgImportReference(value = "MatTableDataSource", reference = "@angular/material/table")
@NgImportReference(value = "ViewChild", reference = "@angular/core")
@Getter
@Setter
@Accessors(chain = true)

@NgMethod("""
        public applyFilter(event: Event) {
            const filterValue = (event.target as HTMLInputElement).value;
            if(this.dataSource)
            this.dataSource.filter = filterValue.trim().toLowerCase();
          }
        """)
@NgMethod("""
        public applyFilterText(value : string) {
        		if (this.dataSource)
        			this.dataSource.filter = value.trim().toLowerCase();
        	}""")

@NgInput("paginator")
public class MatTable<J extends MatTable<J>> extends Table<J> implements INgComponent<J>
{
    private String dataSource;
    private List<MatTableColumn> columns = new ArrayList<>();
    private List<String> columnOrder = new ArrayList<>();

    private MatTableHeaderRow headerRow = new MatTableHeaderRow();
    private MatTableRow tableRow = new MatTableRow();
    private MatTablePaginator paginator = new MatTablePaginator();

    private boolean sortEnabled;
    private boolean paginateEnabled;

    public MatTable()
    {
        addAttribute("mat-table", "");
    }

    @Override
    public Set<String> moduleImports()
    {
        Set<String> strings = INgComponent.super.moduleImports();
        strings.add("MatTableModule");
        //strings.add("MatPaginatorModule");
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
            fields.add(" dataSource?: MatTableDataSource<any>;");
            fields.add(" @ViewChild(MatSort) sort?: MatSort;");
            //fields.add(" @ViewChild(MatPaginator) paginator?: MatPaginator;");
        }

        return fields;
    }

    @Override
    public List<String> constructorBody()
    {
        List<String> strings = INgComponent.super.constructorBody();
        strings.add("this.dataSource = new MatTableDataSource(this." + dataSource + ");");
        if (sortEnabled)
        {
            strings.add("""
                                if (this.dataSource && this.sort)
                                                this.dataSource.sort = this.sort!;""");
        }

        if (paginateEnabled)
        {
            strings.add("""
                                if (this.dataSource && this.paginator)
                                                this.dataSource.paginator = this.paginator!;""");
        }
        return strings;
    }

    @Override
    protected void init()
    {
        addAttribute("*ngIf", "dataSource");
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
                    sortEnabled = true;
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
