/**
 * 
 */
	$(".pager").click(function(){
		let p = $(this).attr("title");
		$("#curPage").val(p);
		$("#frm").submit();
	});