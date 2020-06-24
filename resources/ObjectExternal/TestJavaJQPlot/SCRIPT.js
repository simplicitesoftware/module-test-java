var TestJavaJQPlot = TestJavaJQPlot || (function ($) {

	function render(params) {
		$.jqplot('testjqplot', [[ 350 ]], {
			seriesDefaults: {
				renderer: $.jqplot.MeterGaugeRenderer,
				rendererOptions: { min: 100, max: 500, intervals:[ 200, 300, 400, 500 ], intervalColors:['#66cc66', '#93b75f', '#E7E658', '#cc6666']
				}
			}
		});
	}

	return { render: render };

})(jQuery);