<template>
  <el-container>
    <el-main>
      <el-form
        :model="ruleForm"
        :rules="rules"
        ref="ruleForm"
        label-width="100px"
        class="demo-ruleForm"
      >
        <el-form-item label="题目" prop="question">
          <el-input type="textarea" :rows="5" v-model="ruleForm.question"></el-input>
        </el-form-item>
        <el-form-item label="答案" prop="answer">
          <el-input type="textarea" :rows="5" v-model="ruleForm.answer"></el-input>
        </el-form-item>
        <el-form-item label="多图片" prop="pics">
          <el-upload
            class="upload-demo"
            drag
            action="https://jsonplaceholder.typicode.com/posts/"
            :before-remove="beforeRemove"
            multiple
          >
            <i class="el-icon-upload"></i>
            <div class="el-upload__text">
              将文件拖到此处，或
              <em>点击上传</em>
            </div>
            <div class="el-upload__tip" slot="tip">只能上传jpg/png文件，且不超过500kb</div>
          </el-upload>
        </el-form-item>
        <el-form-item label="音频" prop="sound">
          <el-upload
            class="upload-demo"
            action="https://jsonplaceholder.typicode.com/posts/"
            :on-preview="handlePreview"
            :on-remove="handleRemove"
            :before-remove="beforeRemove"
            multiple
            :limit="1"
            :on-exceed="handleExceed"
            :beforeUpload="beforeUpload"
            :file-list="fileList"
          >
            <el-button size="small" type="primary" style="margin-top: 10px">点击上传</el-button>
            <div slot="tip" class="el-upload__tip">只能上传一个mp3文件，且不超过500kb</div>
          </el-upload>
        </el-form-item>
        <el-form-item label="标签" prop="tags">
          <div style="margin-bottom: 0px">
            <el-select
              v-model="value"
              multiple
              filterable
              allow-create
              default-first-option
              size="medium"
              placeholder="请选择题目标签"
            >
              <el-option
                v-for="item in options"
                :key="item.value"
                :label="item.label"
                :value="item.value"
              ></el-option>
            </el-select>
          </div>
        </el-form-item>
        <el-form-item label="额外信息">
          <el-input-number
            v-model="OptionNum"
            @change="OptionHandleChange"
            :min="0"
            :max="10"
            label="描述文字"
          ></el-input-number>
          <div v-for="index in OptionNum" :key="index">
            <el-form ref="form" :model="form" label-width="0px" @input="addOption">
              <el-row>
                <el-col :span="6">
                  <el-form-item label>
                    <label>key值：</label>
                    <el-input v-model="form.option[index]" placeholder="请输入选项"></el-input>
                  </el-form-item>
                </el-col>
                <el-col :span="6">
                  <el-form-item label>
                    <label>value值：</label>
                    <el-input v-model="form.text[index]" placeholder="请输入内容"></el-input>
                  </el-form-item>
                </el-col>
              </el-row>
            </el-form>
          </div>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="submitForm('ruleForm')">提交</el-button>
          <el-button @click="resetForm('ruleForm')">重置</el-button>
        </el-form-item>
      </el-form>
    </el-main>
  </el-container>
</template>

<script >
import ProblemFullData from "../data/model/ProblemFullData";
import { addProblem } from "../api/Problem";
import { getTagsList } from "../api/Tag";

export default {
  name: "InputTiku",
  data() {
    return {
      OptionNum: 0,
      dialogImageUrl: "",
      dialogVisible: false,
      disabled: false,
      fileList: [],
      ruleForm: {
        question: "",
        answer: "",
        pics: "",
        sound: "",
        tags: ""
      },
      form: {
        option: ["", "choice_A", "choice_B", "choice_C", "choice_D"],
        text: {}
      },
      rules: {
        question: [{ required: true, message: "请输入题目", trigger: "blur" }],
        answer: [{ required: true, message: "请输入题目", trigger: "blur" }]
      },
      options: [],
      value: []
    };
  },
  methods: {
    getTags() {
      var _this = this;
      let callback = (pd, size) => {
        this.$store.commit("setNewCommits", pd);
        pd.filter(v => {
          let ress = {
            value: v.value,
            label: v.value
          };
          this.options.push(ress);
        });
      };
      getTagsList(0, callback, 0);
    },

    submitForm(formName) {
      let _this = this;
      let pd = { problem: {}, answer: {} };
      pd.problem.problemText = this.ruleForm.question;
      pd.answer.answerText = this.ruleForm.answer;
      pd.tags = [];
      this.value.forEach(v => {
        pd.tags.push({
          value: v
        });
      });
      pd.extData = {};
      var me = this;
      Object.keys(this.form.text).forEach(function(key) {
        let keyname = me.form.option[key];
        let value = me.form.text[key];
        pd.extData[keyname] = value;
      });
      this.$refs[formName].validate(valid => {
        if (valid) {
          addProblem(pd, b => {
            if (b.code === "ok") {
              this.$message({ type: "success", message: "添加成功!" });
              this.$router.replace({ path: "/VerifyTable" });
              // todo 返回上一页
            } else {
              this.$message({ type: "error", message: "添加失败!\n" + b.data });
            }
          });
        } else {
          console.log("数据不正确");
          return false;
        }
      });
    }
  },
  mounted: function() {
    this.getTags();
  }
};
</script>

<style scoped>
</style>
