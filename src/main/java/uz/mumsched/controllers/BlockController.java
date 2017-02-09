package uz.mumsched.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import uz.mumsched.dao.BlockDao;
import uz.mumsched.entity.Block;

/**
 * Created by sherxon on 2/2/17.
 */
@RestController
@RequestMapping(value = "/block")
public class BlockController {

    @Autowired
    BlockDao blockDao;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Iterable<Block> entries(){
       return blockDao.findAll();
    }

    @RequestMapping(value = "/")
    public ModelAndView list(){
       return new ModelAndView("block/list");
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Block find(@PathVariable Long id){
        return blockDao.findOne(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id){
        blockDao.delete(id);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Block create(Block block){
        blockDao.save(block);
        return block;
    }

}
