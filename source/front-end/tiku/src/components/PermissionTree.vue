<template>
  <el-tree
    :data="treeData"
    show-checkbox
    ref="tree"
    node-key="id"
    check-strictly
    :props="defaultProps"
    @check-change="handleCheckChange"
  ></el-tree>
</template>

<script>
import { getPermissionTree } from "../api/Permission";

function loadData() {
  let me = this;
  getPermissionTree(b => {
    me.treeData = b;
  });
}
export default {
  name: "PermissionTreeComp",
  props: {
    onSelectChanged: Function, //(id)
    selectId: Number
  },
  data() {
    return {
      treeData: [],
      selectId_: 0,
      defaultProps: {
        label: "name",
        children: "childPermissions"
      }
    };
  },
  methods: {
    handleCheckChange(data, checked, indeterminate) {
      //实现单选功能
      if (checked === true) {
        //最多只有一个被选中
        // tree 要设置  check-strictly
        this.$refs.tree.setCheckedKeys([data.id]);
        this.selectId_ = data.id;
        this.onSelectChanged(data.id);
      }
    },
    loadData
  },
  created() {},
  watch: {
    selectId: function() {
      this.$refs.tree.setCheckedKeys([this.selectId]);
    }
  },
  mounted() {
    this.loadData();
    this.$refs.tree.setCheckedKeys([this.selectId]);
  }
};
</script>

<style scoped>
</style>