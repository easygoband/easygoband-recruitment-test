package controller

import model.Access
import network.APIConnection
import org.apache.poi.ss.usermodel.FillPatternType
import org.apache.poi.ss.usermodel.HorizontalAlignment
import org.apache.poi.ss.usermodel.IndexedColors
import org.apache.poi.ss.usermodel.VerticalAlignment
import org.apache.poi.ss.util.CellRangeAddress
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import java.io.FileOutputStream

/**
 * Class in charge of managing the API.
 *
 * @param executionArguments Program execution arguments.
 */
class APIManager(val executionArguments: Array<String>) {
    /**
     * Function in charge of running the API manager.
     */
    fun runAPIManager() {
        // Makes the API call
        val data = APIConnection().makeAPICall()

        // Checks if the data is empty
        if (!data.isEmpty())
            manageSearchParameters(data)
    }

    /**
     * Function in charge of managing the search parameters.
     *
     * @param data List of data retrieved from the server.
     */
    private fun manageSearchParameters(data: List<Access>) {
        var dataToShow: List<Access> = listOf()

        // Checks if there are enough execution arguments
        if (executionArguments.size == 0 || executionArguments.size < 2) {
            // Sets all the data
            dataToShow = data
        } else {
            // Checks the method to use
            if (executionArguments[0].equals("searchByID", ignoreCase = true)) {
                // Example: <program> searchByID 14 --> No results
                // Example: <program> searchByID 78 --> Result
                dataToShow = selectDataByID(data, executionArguments[1])
            } else if (executionArguments[0].equals("filterBy", ignoreCase = true)) {
                // Example: <program> filterBy access_group_name=Abono name=sabado
                dataToShow = filterData(data)
            } else if (executionArguments[0].equals("sortBy", ignoreCase = true)) {
                // Example: <program> sortBy access_group_name
                // Example: <program> sortBy name
                // Example: <program> sortBy id
                dataToShow = sortData(data)
            } else if (executionArguments[0].equals("help", ignoreCase = true)) {
                println("----- Available functionalities: -----")
                println("- searchByID (i.e. searchByID 78)")
                println("- filterBy (i.e. filterBy access_group_name=Abono name=sabado")
                println("- sortBy (i.e. sortBy id / sortBy name / sortBy access_group_name)")
            } else {
                // Notifies about an incorrect functionality
                println("Error! The specified functionality is not available. All results being retrieved...\n")

                // Notifies about the available functionalities
                println("----- Available functionalities: -----")
                println("- searchByID (i.e. searchByID 78)")
                println("- filterBy (i.e. filterBy access_group_name=Abono name=sabado")
                println("- sortBy (i.e. sortBy id / sortBy name / sortBy access_group_name)\n")

                // Will retrieve the entire data set
                dataToShow = data
            }
        }

        // Shows the size of the data collected
        println("# results: ${dataToShow.size}")

        // Prints the selected data
        // println(dataToShow)

        // Generates the Excel file
        generateExcelFile(dataToShow)
    }

    /**
     * Function in charge of selecting the data by the ID.
     *
     * @param data List of data retrieved from the server.
     * @param searchCriteria ID to find.
     *
     * @return New list of data that matches the chosen criteria.
     */
    private fun selectDataByID(data: List<Access>, searchCriteria: String): List<Access> {
        var newData: List<Access> = listOf()

        // Checks the entire set of data
        for (access in data) {
            // If the search matches
            if (access.id.toString().equals(searchCriteria))
                newData += access
        }

        return newData
    }

    /**
     * Function in charge of filtering the data.
     *
     * @param data List of data retrieved from the server.
     *
     * @return New list of data that matches the chosen filters.
     */
    private fun filterData(data: List<Access>): List<Access> {
        var newData: List<Access> = listOf()
        var found: Boolean = true

        // Checks the entire set of data
        for (access in data) {
            // Sets the default value
            found = false

            // Checks every other execution argument
            for (i in 1 until executionArguments.size) {
                // Splits the filter criteria into a key-value pair
                var filterCriteria: Array<String> = getFilterCriteria(executionArguments[i])

                // If there is a key and a value...
                if (filterCriteria.size >= 2) {
                    // Checks the filter criteria key
                    if (filterCriteria[0].equals("access_group_name", ignoreCase = true)) {
                        if (access.accessGroupName.contains(filterCriteria[1], ignoreCase = true))
                            found = true
                    } else if (filterCriteria[0].equals("access_group_id", ignoreCase = true)) {
                        if (access.accessGroupID.toString().equals(filterCriteria[1]))
                            found = true
                    } else if (filterCriteria[0].equals("total_uses", ignoreCase = true)) {
                        if (access.totalUses.toString().equals(filterCriteria[1]))
                            found = true
                    } else if (filterCriteria[0].equals("event_id", ignoreCase = true)) {
                        if (access.eventID.toString().equals(filterCriteria[1]))
                            found = true
                    } else if (filterCriteria[0].equals("structure_decode", ignoreCase = true)) {
                        if (access.structureDecode.toString().equals(filterCriteria[1]))
                            found = true
                    } else if (filterCriteria[0].equals("name", ignoreCase = true)) {
                        if (access.name.contains(filterCriteria[1], ignoreCase = true))
                            found = true

                        for (session in access.sessions)
                            if (session.name.contains(filterCriteria[1], ignoreCase = true))
                                found = true
                    } else if (filterCriteria[0].equals("id", ignoreCase = true)) {
                        if (access.id.toString().equals(filterCriteria[1], ignoreCase = true))
                            found = true

                        for (session in access.sessions)
                            if (session.id.toString().equals(filterCriteria[1], ignoreCase = true))
                                found = true
                    } else if (filterCriteria[0].equals("basic_product_id", ignoreCase = true)) {
                        if (access.basicProductID.toString().equals(filterCriteria[1]))
                            found = true
                    } else {
                        found = false
                    }
                }
            }

            // If the filter criteria matches...
            if (found)
                newData += access
        }

        return newData
    }

    /**
     * Function in charge of splitting the filtering criteria.
     *
     * @param filterCriteria Filter criteria.
     *
     * @return Filter criteria splitted.
     */
    private fun getFilterCriteria(filterCriteria: String): Array<String> {
        return filterCriteria.split("=").toTypedArray()
    }

    /**
     * Function in charge of sorting the data.
     *
     * @param data List of data retrieved from the server.
     *
     * @return New list with the data sorted.
     */
    private fun sortData(data: List<Access>): List<Access> {
        var newData: List<Access> = listOf()

        // Converts the set into a mutable list
        newData = data.toMutableList()

        // Checks if there are enough arguments
        if (executionArguments.size >= 2) {
            // Checks the sorting criteria
            when (executionArguments[1]) {
                "access_group_name" -> {
                    newData = newData.sortedBy { it.accessGroupName }
                }

                "access_group_id" -> {
                    newData = newData.sortedBy { it.accessGroupID }
                }

                "total_uses" -> {
                    newData = newData.sortedBy { it.totalUses }
                }

                "event_id" -> {
                    newData = newData.sortedBy { it.eventID }
                }

                "structure_decode" -> {
                    newData = newData.sortedBy { it.structureDecode }
                }

                "name" -> {
                    newData = newData.sortedBy { it.name }
                }

                "modified" -> {
                    newData = newData.sortedBy { it.modified }
                }

                "id" -> {
                    newData = newData.sortedBy { it.id }
                }

                "basic_product_id" -> {
                    newData = newData.sortedBy { it.basicProductID }
                }
            }
        }

        return newData
    }

    /**
     * Function in charge of generating an Excel file.
     *
     * @param data List of data retrieved from the server.
     */
    private fun generateExcelFile(data: List<Access>) {
        var i: Int = 2
        var begin: Int = 0
        var end: Int = 0
        var width: Int = 1

        val columns = arrayOf<String>("Access Group Name", "Access Group ID", "Total Uses", "Event ID", "Structure Decode",
            "Name", "Modified", "ID", "Basic Product ID", "Sessions", "")
        val subcolumns = arrayOf<String>("", "", "", "", "", "", "", "", "", "Name", "ID")

        // The file is being generated...
        println("\nThe Excel file is being generated...")

        // Creates the workbook object for the Excel file
        val workbook = XSSFWorkbook()

        // Creates the spreadsheet object
        val spreadsheet = workbook.createSheet("Accesses Data")

        // Creates the header font
        val headerFont = workbook.createFont()
        headerFont.setBold(true)
        headerFont.setFontHeightInPoints(12)
        headerFont.setColor(IndexedColors.BLACK.index)

        // Creates the header style
        val headerStyle = workbook.createCellStyle()
        headerStyle.setFont(headerFont)
        headerStyle.setFillForegroundColor(IndexedColors.SKY_BLUE.index)
        headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        headerStyle.setVerticalAlignment(VerticalAlignment.CENTER)
        headerStyle.setAlignment(HorizontalAlignment.CENTER)

        // Creates the body font
        val bodyFont = workbook.createFont()
        bodyFont.setBold(false)
        bodyFont.setFontHeightInPoints(12)
        bodyFont.setColor(IndexedColors.BLACK.index)

        // Creates the body style
        val bodyStyle = workbook.createCellStyle()
        bodyStyle.setFont(bodyFont)
        bodyStyle.setFillForegroundColor(IndexedColors.PALE_BLUE.index)
        bodyStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        bodyStyle.setVerticalAlignment(VerticalAlignment.CENTER)
        bodyStyle.setAlignment(HorizontalAlignment.CENTER)

        // Creates the header rows
        val headerRow = spreadsheet.createRow(0)
        val subheaderRow = spreadsheet.createRow(1)

        // Sets the header columns
        for (col in columns.indices) {
            val cell = headerRow.createCell(col)
            cell.setCellValue(columns[col])
            cell.setCellStyle(headerStyle)
            spreadsheet.autoSizeColumn(col)
            width = maxOf(width, spreadsheet.getColumnWidth(0))
        }

        // Sets the subheader columns
        for (col in subcolumns.indices) {
            val cell = subheaderRow.createCell(col)
            cell.setCellValue(subcolumns[col])
            cell.setCellStyle(headerStyle)
            spreadsheet.autoSizeColumn(col)
            width = maxOf(width, spreadsheet.getColumnWidth(0))
        }

        // Merges the header cells
        for (i in 0..8)
            spreadsheet.addMergedRegion(CellRangeAddress(0,1, i, i))
        spreadsheet.addMergedRegion(CellRangeAddress(0,0, 9, 10))

        // For each access entry...
        for (access in data) {
            // Sets the first and last marks
            begin = i
            end = i

            var row = spreadsheet.createRow(i)

            // Access group name
            var cell = row.createCell(0)
            cell.setCellValue(access.accessGroupName)
            cell.setCellStyle(bodyStyle)
            spreadsheet.autoSizeColumn(0)
            width = maxOf(width, spreadsheet.getColumnWidth(0))

            // Access group ID
            cell = row.createCell(1)
            cell.setCellValue(access.accessGroupID.toString())
            cell.setCellStyle(bodyStyle)
            spreadsheet.autoSizeColumn(1)
            width = maxOf(width, spreadsheet.getColumnWidth(1))

            // Total uses
            cell = row.createCell(2)
            cell.setCellValue(access.totalUses.toString())
            cell.setCellStyle(bodyStyle)
            spreadsheet.autoSizeColumn(2)
            width = maxOf(width, spreadsheet.getColumnWidth(2))

            // Event ID
            cell = row.createCell(3)
            cell.setCellValue(access.eventID.toString())
            cell.setCellStyle(bodyStyle)
            spreadsheet.autoSizeColumn(3)
            width = maxOf(width, spreadsheet.getColumnWidth(3))

            // Structure decode
            cell = row.createCell(4)
            cell.setCellValue(access.structureDecode.toString())
            cell.setCellStyle(bodyStyle)
            spreadsheet.autoSizeColumn(4)
            width = maxOf(width, spreadsheet.getColumnWidth(4))

            // Name
            cell = row.createCell(5)
            cell.setCellValue(access.name)
            cell.setCellStyle(bodyStyle)
            spreadsheet.autoSizeColumn(5)
            width = maxOf(width, spreadsheet.getColumnWidth(5))

            // Modified
            cell = row.createCell(6)
            cell.setCellValue(access.modified)
            cell.setCellStyle(bodyStyle)
            spreadsheet.autoSizeColumn(6)
            width = maxOf(width, spreadsheet.getColumnWidth(6))

            // ID
            cell = row.createCell(7)
            cell.setCellValue(access.id.toString())
            cell.setCellStyle(bodyStyle)
            spreadsheet.autoSizeColumn(7)
            width = maxOf(width, spreadsheet.getColumnWidth(7))

            // Basic product ID
            cell = row.createCell(8)
            cell.setCellValue(access.basicProductID.toString())
            cell.setCellStyle(bodyStyle)
            spreadsheet.autoSizeColumn(8)
            width = maxOf(width, spreadsheet.getColumnWidth(8))

            for (session in access.sessions) {
                if (i > begin)
                    row = spreadsheet.createRow(i)

                // Session name
                cell = row.createCell(9)
                cell.setCellValue(session.name)
                cell.setCellStyle(bodyStyle)
                spreadsheet.autoSizeColumn(9)
                width = maxOf(width, spreadsheet.getColumnWidth(9))

                // Session name
                cell = row.createCell(10)
                cell.setCellValue(session.id.toString())
                cell.setCellStyle(bodyStyle)
                spreadsheet.autoSizeColumn(10)
                width = maxOf(width, spreadsheet.getColumnWidth(10))

                // Updates the last mark
                end = i

                // Increases the row id
                i++
            }

            if (begin != end)
                for (j in 0..8)
                    spreadsheet.addMergedRegion(CellRangeAddress(begin, end, j, j))

            // Increases the row id
            if (access.sessions.size == 0)
                i++
        }

        // Autosizes the columns in the table
        for (i in 0..10) {
            spreadsheet.setColumnWidth(i, width)
        }

        // Creates the file to write
        val file = FileOutputStream("./Results.xlsx")

        // Writes the file content
        workbook.write(file)

        // Closes the file
        file.close()

        // Closes the Excel file
        workbook.close()

        // The file is generated
        println("The file (./Results.xlsx) is generated.")
    }
}