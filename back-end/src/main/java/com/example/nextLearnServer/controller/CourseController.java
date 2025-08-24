package com.example.nextLearnServer.controller;

import com.example.nextLearnServer.service.CourseService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.crypto.Cipher;
import javax.servlet.http.HttpServletRequest;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Base64;

@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/course/selectAllCourses")
    public Object selectAllCourses() throws Exception{
        //firstly: get course info
        Object courses = courseService.selectAllCourses();
        String coursesJson = new ObjectMapper().writeValueAsString(courses);

        //next: load private key
        String privateKeyString = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCTJ1uT5jzC1f0G5OIVM2sojT2Ny36TY/RsboTGoNu4zhQVLXBjAUfXRtTbeAa1sgNQglRM4rggHSiFlHcIZ9Zm4w0k4drnlbDKmhegBcsVJskFdXCReXwkf+YqrwXpTiF9RUJN527zzchsS22NUo5Fs9z71RSMzgyTNQcQC6bvUsL7DG+IIjnQmReYejAZ01z/j6shn3TSZgdjFH5Uj8znkJkfW0BfCVUsmHckSFGKENQS16DXIKnb8Ok31v8q1SiMooty66DINt/DVN3ozxymCOeAFeXvE/TA9tQH8XhSiGtG1X03iGEwS2nVf2toLKJEU8w/mrl0DOusJzEOG5UPAgMBAAECggEBAIuGJsuN4xCtitLNlBub/D+f47wdNS+U930UMSqP/KU2KE6IHeaRoUdZ7psFK/99AK2GVV3tHb29R92YDmDW66/0GlNdHoy0HsOK5VmiBJNSigl197zHXlDRQDA6cTVsEk7Pq3VoOYhLFnyv6/iyTRmD18SjnW+AMuYkwkSRd7+z1i51O20tOzlZ53F5nMlavjqixSi1cm8Xrw+r9c6og1iHwc5pLM4ljgRYPsiMyL1KjRQAoVQlr68/wimQoYlRxs9lSgAQxzA7QzI08do/RbHHqPz1ysEyqTrqAN45g264oHCj00S0u52k/mxD3IS6fR06YN61Vgd0SrMVsZEm+YECgYEA7nWY9gZZnhx/CIFO4uCYje1i8+t/6kW1Xd3kAZo/Ti8clJC4qhm5UwXUFkHPKHdoywIuk4S2sApVGK56vxR3ard1zCHaOfNeTpkNNPaWsxB1QhCK7wfij7SqWbCW0dGDy0VWbIO5RJ6bTNUIr6Iewny4p36rKrzTVTTI0z8jxM8CgYEAnfpk1mTyS3bHMbhOdol5EaZCv8p9tPCm/xuJgonMY71jZroi1/WmkqhmRxVOG31WWccgmERfpv+w3GZ2YK7zJCrwt1XNct+hNjK4ho/CxqmhZRtOZ5Z5583Kz/U4D+ACCYElqoI3BQ9bDkKW5+cIe2K0wYUP2oh/NSJyFdDPu8ECgYBS1csS+9W51RBT9gdfTMHx25raPN6slRaRyvjfjaOcF0WIXlWn0VPNgWLRcH70AbcHfnSLjjigIpa5AjNlmUh6a8yh4siaBO6nwwcRdO+YuIjjMDfzHPwZC5t5mJxruqpbvHRvMbr0GVy9beuch2bEDOtgU+JF8F5BZRq2N2LHhQKBgAL79eeu5HzUc5LW3nSSyDyzHVOuKY2/dggfpwtWOwwvSa9pGLtnoovmrnftSRpv1a/AeTcnI39uGRMwxE+zPliSjxWHg2gGHW9+qcmw8Yb7MVdNmr+OMiNU2d3vze1O1/sB+4orB4sK7TdpvpwG2zwpcyysrM3+Ahko22raFPKBAoGBANB5t8hdMtEmz1CjNZg5BBMcdXKr48SImJL/OCkMcglVNkWgCMubac7bAbB7Uw+QtIDOuJYGD6ttbI7etZJjKZuufGQ3qcrRQ36QR76nkU/E4+XUpANsBSWspJYusqGj+WRr3mrjB5k2WXrRMaqh3QQ2ButtSwe9xRMS35p2XZM9";
        byte[] privateKeyBytes = Base64.getDecoder().decode(privateKeyString);
        PrivateKey privateKey = KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(privateKeyBytes));

        // then use private key to cipher the info
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, privateKey);
        byte[] encryptedBytes = cipher.doFinal(coursesJson.getBytes());
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }

    @GetMapping("/course/selectCoursesByTeacherId")
    public Object selectCoursesByTeacherId(HttpServletRequest req) {
        int teacherId = Integer.parseInt(req.getParameter("teacherId"));
        return courseService.selectCoursesByTeacherId(teacherId);
    }

    @GetMapping("/course/selectCoursesByStudentId")
    public Object selectCoursesByStudentId(HttpServletRequest req) {
        int studentId = Integer.parseInt(req.getParameter("studentId"));
        return courseService.selectCoursesByStudentId(studentId);
    }

    @GetMapping("/course/selectCoursesByName")
    public Object selectCoursesByName(HttpServletRequest req) {
        String keyword = req.getParameter("keyword");
        return courseService.selectCoursesByName(keyword);
    }

}
