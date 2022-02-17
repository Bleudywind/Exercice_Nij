package com.example.demo.controler;

import com.example.demo.models.MathInteger;
import com.example.demo.models.MathPathInteger;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.HandlerMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/myapp")
public class MathControler {
    @Autowired
    private ObjectMapper objectMapper;

    /*@PostMapping("/{pititePatate}/{moyennePatate}/{grossePatate}")
    public double maths(
            @RequestBody MathInteger bodyPatate,
            @RequestHeader("x-test-1") Integer headerPatate1,
            @RequestHeader("x-test-2") Integer headerPatate2,
            @RequestParam Integer subitem1,
            @RequestParam Integer subitem2,
            @PathVariable Integer pititePatate,
            @PathVariable Integer moyennePatate,
            @PathVariable Integer grossePatate) {

        double result = pititePatate * moyennePatate * grossePatate;
        result = result / subitem1;
        result = result / subitem2;
        result = result + bodyPatate.getValue1() + bodyPatate.getValue2();
        result = result / headerPatate1;
        result = result /headerPatate2;

        return result;
    }*/

    @PostMapping("/{pititePatate}/{moyennePatate}/{grossePatate}")
    public void maths(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

            MathInteger mathInteger = new MathInteger();
            MathPathInteger mathPathInteger = new MathPathInteger();

            String subitem1 = request.getParameter("subitem1");
            String subitem2 = request.getParameter("subitem2");
            String bodypatate = request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
            mathInteger = this.objectMapper.readValue(bodypatate, MathInteger.class);
            String headerPatate1 = request.getHeader("x-test-1");
            String headerPatate2 = request.getHeader("x-test-2");

            String pititePatate = request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE).toString();

            pititePatate = pititePatate.replace("=",":");
            pititePatate = pititePatate.replace("grossePatate","\"grossePatate\"");
            pititePatate = pititePatate.replace("pititePatate","\"pititePatate\"");
            pititePatate = pititePatate.replace("moyennePatate","\"moyennePatate\"");
            mathPathInteger = this.objectMapper.readValue(pititePatate, MathPathInteger.class);
            Integer subItem1=Integer.parseInt(subitem1);
            Integer subItem2=Integer.parseInt(subitem2);
            Integer headerPatate1I=Integer.parseInt(headerPatate1);
            Integer headerPatate2I=Integer.parseInt(headerPatate2);


            double result = mathPathInteger.getPititePatate()
                    * mathPathInteger.getGrossePatate()
                    * mathPathInteger.getMoyennePatate();
            result = result / subItem1;
            result = result /subItem2;
            result = result + mathInteger.getValue1() + mathInteger.getValue2();
            result = result / headerPatate1I;
            result = result /headerPatate2I;


            response.setContentType( "text/html" );
            PrintWriter out = response.getWriter();
            out.println( result );
            out.close();
        }

}
