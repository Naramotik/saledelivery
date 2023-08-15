//package ru.murza.saledelivery.util;
//
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.JsonNode;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.github.fge.jsonpatch.JsonPatch;
//import com.github.fge.jsonpatch.JsonPatchException;
//
//public class Patcher<T> {
//    ObjectMapper objectMapper = new ObjectMapper();
//
//    public JsonNode applyPatchToObject(JsonPatch patch, T t) throws JsonPatchException, JsonProcessingException{
//        return patch.apply(objectMapper.convertValue(t, JsonNode.class));
//    } return objectMapper.treeToValue(patched, T.class)
//}
