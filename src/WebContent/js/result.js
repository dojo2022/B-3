/**
 * 
 */

function navigateTo(dest, video_id) {
    switch (dest) {
    case 'read-review': 
        location.href='/';
        break;
    case 'write-review':
        location.href='/';
        break;
    default:
        location.href='/'; 
        break;
    }
}
