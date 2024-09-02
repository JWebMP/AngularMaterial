package com.jwebmp.plugins.angular.material.table;

import com.google.common.base.Strings;
import com.jwebmp.core.base.html.DivSimple;
import com.jwebmp.core.base.html.TableCell;
import com.jwebmp.core.base.html.TableHeader;
import com.jwebmp.core.base.html.interfaces.children.TableChildren;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
public class MatTableColumn extends DivSimple<MatTableColumn> implements TableChildren
{
    private String columnDef;
    private TableHeader<?> header;
    private TableCell<?> cell;

    private boolean sort;

    public MatTableColumn()
    {
        setTag("ng-container");
    }

    @Override
    protected void init()
    {
        if (!Strings.isNullOrEmpty(columnDef))
        {
            addAttribute("matColumnDef", columnDef);
        }
        if (header != null)
        {
            header.addAttribute("mat-header-cell", "");
            header.addAttribute("*matHeaderCellDef", "");
            if (sort)
            {
                header.addAttribute("mat-sort-header", "");
            }
            add(header);
        }
        if (cell != null)
        {
            cell.addAttribute("mat-cell", "");
            cell.addAttribute("*matCellDef", "let element");
            add(cell);
        }
        super.init();
    }

}
