$(function() {
    $("#comment_content")
        .autocomplete(
            {
                source : 'http://localhost:8089/autocomplete',
                minLength : 1,
            });
});