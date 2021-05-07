var TestJavaCytoscape = (function() {

	function render(params) {
		var p = params.parameters;
		console.log(p);
		var code = null;
		if (p.object && p.row_id) {
			var title = $("#testcytoscape-title");
			title.text("Called from " + p.object + " (row ID " + p.row_id + ")");
			$ui.getUIObject(p.object, function(obj) {
				console.log(obj);
				title.append(": Code = " + obj.item.appObj1Code);
				chart(obj.item.appObj1Code, obj.item.appObj1Color);
			});
		} else {
			chart("item")
		}
	}
	
	function chart(code, color) {
		cytoscape({
		  container: $("#testcytoscape"),
		  elements: [
		  	{ data: { id: "a", label: code + "-a" } },
		  	{ data: { id: "b", label: code + "-b" } },
		  	{ data: { id: "c", label: code + "-c" } },
		  	{ data: { id: "ab", source: "a", target: "b" } },
		  	{ data: { id: "bc", source: "b", target: "c" } },
		  	{ data: { id: "ca", source: "a", target: "c" } }
		  ],
		  style: [
		    { selector: "node", style: { "background-color": color || "#ccc", "label": "data(label)" } },
		    { selector: "edge", style: { "width": 3, "line-color": "#ccc", "target-arrow-color": "#ccc", "target-arrow-shape": "triangle" } }
		  ],
		  layout: { name: "grid", rows: 1 }
		});

	}

	return { render: render };
})();