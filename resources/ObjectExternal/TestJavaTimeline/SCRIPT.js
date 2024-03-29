var TestJavaTimeline = (function() {

	function calendar() {
		new FullCalendar.Calendar($("#testtimeline")[0], {
			plugins: [ 'interaction', 'resourceTimeline' ],
			defaultView: 'resourceTimelineDay',
			aspectRatio: 1.5,
			header: { left: 'prev,next', center: 'title', right: 'resourceTimelineDay,resourceTimelineWeek,resourceTimelineMonth' },
			editable: false,
			resourceLabelText: 'Rooms',
			resources: 'https://fullcalendar.io/demo-resources.json?with-nesting&with-colors',
			events: 'https://fullcalendar.io/demo-events.json?single-day&for-resource-timeline'
		}).render();
	}

	return { render: function(params) {
		$ui.loadCalendar(calendar);
	}};

})();