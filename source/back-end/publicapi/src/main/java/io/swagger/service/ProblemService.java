package io.swagger.service;

import cn.czfshine.tiku.pojo.ProblemFullData;
import cn.czfshine.tiku.pojo.dao.Problem;
import io.swagger.model.Expression;
import io.swagger.utils.ParserErrorException;

import java.util.List;

public interface ProblemService {
    List<ProblemFullData> queryProblem(Expression expressione) throws ParserErrorException;
}
