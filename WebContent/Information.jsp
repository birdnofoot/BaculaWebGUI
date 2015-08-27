<!doctype html>
<html lang="en">
<head>
<%@ include file="navbar.jsp" %>
<script src="http://code.highcharts.com/highcharts.js"></script>
<title>Information - Bacula Web GUI</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>

<body>
		<div class = "container">
		<div class="page-header">
		<h1>Information</h1>
		</div>
		<%
	    	File root = new File(Constant.getRoot());
	    	long total = root.getTotalSpace();
	    	long usable = root.getUsableSpace();
	    	long used = total - usable ;
	    	String used_space =  Objects.toString((used), null);
	    	Map<String,Long> listClientSize = AppUtils.getSortedClientSizeMap(Constant.getDefault_backup_path());
		%>
		<br/>
		
		<div align = "left">
		<div class="col-xs-3">
		<div class="well" >
		<h4><b>Space</b></h4>
		<br/>
		<p>Total space : <%=AppUtils.formatFileSize(Objects.toString(total,null))%></p>
		<p>Used space : <%=AppUtils.formatFileSize(Objects.toString(used,null)) %></p>
		<p>Free space : <%=AppUtils.formatFileSize(Objects.toString(usable,null)) %></p>
		</div>
		</div>
		
		<div id="pie" style="min-width: 450px; height: 450px; max-width: 450px">
		<script type="text/javascript">
		$(function () {
    	$('#pie').highcharts({
        chart: {
            plotBackgroundColor: null,
            plotBorderWidth: null,
            plotShadow: false,
            type: 'pie'
        },
        credits: false,
        title: {
            text: 'Space usage on <%=Constant.getHost_name()%>'
        },
        tooltip: {
            pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
        },
        plotOptions: {
            pie: {
                allowPointSelect: true,
                cursor: 'pointer',
                dataLabels: {
                    enabled: true,
                    format: '<b>{point.name}</b>: {point.percentage:.1f} %',
                    style: {
                        color: (Highcharts.theme && Highcharts.theme.contrastTextColor) || 'black'
                    }
                }
            }
        },
        series: [{
            name: "Disk",
            colorByPoint: true,
            data: [{
                name: "Used space",
                y: <%=used%>
            }, {
                name: "Free space",
                y: <%=usable%>,
                sliced: true,
                selected: true
	            }]
	        }]
	    	});
		});
		</script>
		</div>
		</div>
		<br/>
		<br/>
		
		
		<div align="left">
		<div class="col-xs-3">
		<div class="well" >
		<h4><b>Space per client</b></h4>
		<br/>
		<%

		for (Map.Entry<String, Long> entry : listClientSize.entrySet()) {
		    String clientname = entry.getKey().toString();
		    String clientsize = AppUtils.formatFileSize(Objects.toString(entry.getValue(),null));
		    out.println("<p>"+clientname+" : "+clientsize+"</p>");
		}
		%>
		</div>
		</div>
		
		<div id="pie2" style="min-width: 500px; height: 500px; max-width: 500px">
		<script type="text/javascript">
		$(function () {
    	$('#pie2').highcharts({
        chart: {
            plotBackgroundColor: null,
            plotBorderWidth: null,
            plotShadow: false,
            type: 'pie'
        },
        credits: false,
        title: {
            text: 'Space per client'
        },
        tooltip: {
            pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
        },
        plotOptions: {
            pie: {
                allowPointSelect: true,
                cursor: 'pointer',
                dataLabels: {
                    enabled: true,
                    format: '<b>{point.name}</b>: {point.percentage:.1f} %',
                    style: {
                        color: (Highcharts.theme && Highcharts.theme.contrastTextColor) || 'black'
                    }
                }
            }
        },
        series: [{
            name: "Disk usage percentage",
            colorByPoint: true,
            
            data: [
            	<%
            	boolean first = true;
            	for (Map.Entry<String, Long> entry : listClientSize.entrySet()) {
            	    String name = entry.getKey().toString();;
            	    String size = Objects.toString(entry.getValue(),null);
            	    if (first)
            	        first = false;
            	    else
            	    out.println("},");
            	    out.println("{");
            	    out.println("name : \""+name+"\",");
            	    out.println("y:"+size);
            	}
            	out.println("}");
            	%>
            	]
	        }]
	    	});
		});
		</script>
		</div>
		</div>
		</div>
</body>
</html>