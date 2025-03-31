import {request} from '@/plugins/axios'

export function getcourtsPage (data,pageNum) {
    return request({
        url:'/courts/page?pageNum='+pageNum,
        method: 'post',
        data: data
    })
}

export function getbookingsPage (data,pageNum) {
    return request({
        url:'/bookings/page?pageNum='+pageNum,
        method: 'post',
        data: data
    })

}

export function getbasketballcoursePage (data,pageNum) {
    return request({
        url:'/basketballcourse/page?pageNum='+pageNum,
        method: 'post',
        data: data
    })
}
export function getequipmentliststPage (data,pageNum) {
    return request({
        url:'/equipmentlistst/page?pageNum='+pageNum,
        method: 'post',
        data: data
    })
}
export function getsgvideoPage (data,pageNum) {
    return request({
        url:'/sgvideo/page?pageNum='+pageNum,
        method: 'post',
        data: data
    })
}
export function getusersPage (data,pageNum) {
    return request({
        url:'/users/page?pageNum='+pageNum,
        method: 'post',
        data: data
    })
}
export function updateCourtState (data) {
    return request({
        url:'/courts/updateState',
        method: 'post',
        data: data
    })
}
export function createBooking (data) {
    return request({
        url:'/bookings/create',
        method: 'post',
        data: data
    })
}

export function deleteBooking (bookingid) {
    return request({
        url:`/bookings/delete/${bookingid}`,
        method: 'delete'
    })
}

export function confirmBooking (bookingid) {
    return request({
        url:`/bookings/confirm/${bookingid}`,
        method: 'put'
    })
}
export function updateCourtInfo(data) {
    return request({
        url: '/courts/updateInfo',
        method: 'post',
        data: data
    });
}

export function onlineCourseApi(courseId) {
    return request({
        url: `/basketballcourse/online/${courseId}`,
        method: 'put'
    });
}

export function offlineCourseApi(courseId) {
    return request({
        url: `/basketballcourse/offline/${courseId}`,
        method: 'put'
    });
}

export function deleteCourseApi(courseId) {
    return request({
        url: `/basketballcourse/delete/${courseId}`,
        method: 'delete'
    });
}

export function addCourseApi(course) {
    return request({
        url: '/basketballcourse/add',
        method: 'post',
        data: course
    });
}

export function signUpCourse(courseId) {
    return request({
        url: `/basketballcourse/signup/${courseId}`,
        method: 'post'
    });
}

export function cancelSignUpCourse(courseId) {
    return request({
        url: `/basketballcourse/cancelSignup/${courseId}`,
        method: 'post'
    });
}
export function getAnnouncementsPage(data,pageNum) {
    return request({
        url: '/announcements/page?pageNum='+pageNum,
        method: 'post',
        data: data,
    });
}

export function getCarouseiimagesPage(data,pageNum) {
    return request({
        url: '/carouseiimages/page?pageNum='+pageNum, // 需根据实际情况修改接口地址
        method: 'post',
        data: data,
    });
}

export function getSportsnewsPage(data,pageNum) {
    return request({
        url: '/sportsnews/page?pageNum='+pageNum, // 需根据实际情况修改接口地址
        method: 'post',
        data: data,
    });
}