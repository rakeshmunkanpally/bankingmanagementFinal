<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<tags:Master2 heading="Transaction Details Page" title="Details Page">
<jsp:attribute name="header">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<style>
        table {
            border-collapse: collapse;
            width: 100%;
        }
 
        th,
        td {
            padding: 5px;
            text-align: left;
            border-bottom: 1px solid #DDD;
        }
        tr:hover {
        }
        tr:nth-child(even) {
        background-color: #ADD8E6;
        }
        .pagination {
            text-align: center;
            margin-top: 10px;
        }
        .pagination a {
            color: black;
            display: inline-block;
            padding: 8px 16px;
            text-decoration: none;
            transition: background-color .3s;
        }
.pagination a.active {
            background-color: dodgerblue;
            color: white;
        }
 
        .pagination a:hover:not(.active) {
            background-color: #ddd;
        }
 
  
 
#pagination {
            list-style: none;
            padding: 0;
            margin: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            margin-top: 20px;
        }

        #pagination li {
            display: inline-block;
            margin-right: 5px;
        }

        #pagination li a {
            text-decoration: none;
            padding: 5px 10px;
            border: 1px solid #ddd;
            color: #333;
            border-radius: 3px;
        }

        #pagination li.active {
            background-color: dodgerblue;
        }

        #pagination li a:hover:not(.active) {
            background-color: #ddd;
        }
         #background {
            display: none;
        }

    
    </style>
    <script type="text/javascript">
    var itemsPerPage = 5; 
    var dataArray = [];
    <c:forEach var="transaction" items="${transactionList}">
    dataArray.push({
        transactionDate: '${transaction.trasactionDate}',
        description: '${transaction.description}',
        referenceNo: '${transaction.referenceNo}',
        amount: ${transaction.amount},
        balance: ${transaction.balance},
        remarks: '${transaction.remarks}'
    });
    </c:forEach>
            function loadPage(page) {
            	
                var startIndex = (page - 1) * itemsPerPage;
                var endIndex = startIndex + itemsPerPage;
                var slicedData = dataArray.slice(startIndex, endIndex);

                displayData(slicedData);
                updatePaginationLinks(page);
            }
      
            function displayData(data) {
                var contentHtml = '<table class="table table-striped table-bordered" style="font-size: medium; margin-top: 20px; box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);" id="print-table">' +
                    '<thead class="thead-light"><tr align="center">' +
                    '<th scope="col">Transaction Date</th>' +
                    '<th scope="col">Description</th>' +
                    '<th scope="col">Reference No</th>' +
                    '<th scope="col">Debit</th>' +
                    '<th scope="col">Credit</th>' +
                    '<th scope="col">Balance</th>' +
                    '<th scope="col">Remarks</th>' +
                    '</tr></thead><tbody>';

                $.each(data, function (index, item) {
                    contentHtml += '<tr align="center">' +
                        '<td style="padding: 8px;">' + item.transactionDate + '</td>' +
                        '<td style="padding: 8px;">' + item.description + '</td>' +
                        '<td style="padding: 8px;">' + item.referenceNo + '</td>';

                    if (item.description === 'CREDIT' || item.description === "DEPOSIT") {
                        contentHtml += '<td style="padding: 8px;"></td>' +
                            '<td style="padding: 8px;">' + item.amount + '</td>';
                    }

                    if (item.description === 'DEBIT' || item.description === "WITHDRAW") {
                        contentHtml += '<td style="padding: 8px;">' + item.amount + '</td>' +
                            '<td style="padding: 8px;"></td>';
                    }

                    contentHtml += '<td style="padding: 8px;">' + item.balance + '</td>' +
                        '<td style="padding: 8px;">' + item.remarks + '</td>' +
                        '</tr>';
                });

                contentHtml += '</tbody></table>';
                $('#pagination-container').html(contentHtml);
            }


            function updatePaginationLinks(currentPage) {
            	
                var totalPages = Math.ceil(dataArray.length / itemsPerPage);

                var paginationHtml = '';
                for (var i = 1; i <= totalPages; i++) {
                    if (i === currentPage) {
                        paginationHtml += '<li class="active"><span>' + i + '</span></li>';
                    } else {
                        paginationHtml += '<li><a href="#" onclick="loadPage(' + i + ');">' + i + '</a></li>';
                    }
                }
                $('#pagination').html(paginationHtml);
            }
        $(document).ready(function () {
            loadPage(1);
            $("#pagination").click(function(){
            var width=$("pagination").length*3;
            $(".pagination").attr("width",width);
            });
            
        });
        function printDetails() {
            var contentToPrint = $('#print-table').clone(); // Clone only the table
            var printWindow = window.open('', '_blank', 'width=1200,height=800');
            printWindow.document.write('<html><head><title>Print</title>');
            printWindow.document.write('<link rel="stylesheet" type="text/css" href="path/to/print-styles.css">');
            printWindow.document.write('</head><body style="text-align:center;">'); // Center the content
            printWindow.document.write('<style>');
            printWindow.document.write('table { width: 100%; border-collapse: collapse; }');
            printWindow.document.write('th, td { padding: 8px; text-align: center; border: 1px solid #ddd; }');
            printWindow.document.write('</style>');
            printWindow.document.write(contentToPrint.prop('outerHTML')); // Append the cloned table
            printWindow.document.write('</body></html>');
            printWindow.document.close();

            // Center the print window on screen
            var left = (screen.width - printWindow.outerWidth) / 2;
            var top = (screen.height - printWindow.outerHeight) / 2;
            printWindow.moveTo(left, top);

            printWindow.print();
        }


    </script>
</jsp:attribute>
	<jsp:attribute name="content">
 <div id="pagination-container" style="position:absolute;margin-left: 5%; width: 90%">
    </div><br>

    <ul id="pagination" class="pagination" style="position:absolute; margin-left: 40%; background-color: white;margin-top: 12%">
    </ul><br>
<button style="position:absolute; margin-left:48%; background-color:white; margin-top: 15%" onclick="printDetails();">Print</button>


</jsp:attribute>
</tags:Master2>
