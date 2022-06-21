/**
 * 
 */

function navigateTo(dest, video_id) {
    switch (dest) {
    case 'read-review': 
        location.href=`/FLIFRE/Review_bfServlet?video_id=${video_id}`;
        break;
    case 'write-review':
        location.href=`/FLIFRE/PostServlet?video_id=${video_id}`;
        break;
    default: 
        break;
    }
}
