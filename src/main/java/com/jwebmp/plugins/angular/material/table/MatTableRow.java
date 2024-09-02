package com.jwebmp.plugins.angular.material.table;

import com.jwebmp.core.base.html.TableRow;
import lombok.experimental.Accessors;

@Accessors(chain = true)
public class MatTableRow extends TableRow<MatTableRow>
{
    public MatTableRow()
    {
        addAttribute("mat-row", "");
        addAttribute("*matRowDef", "let row; columns: displayedColumns;let index = dataIndex;let even = even; ");
    }
}
