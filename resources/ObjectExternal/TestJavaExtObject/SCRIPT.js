var TestJavaExtObject = TestJavaExtObject || (function($) {
	function render() {
		$('#testjavaobject').html("Hello world!");
	}

	return { render: render };
})(jQuery);