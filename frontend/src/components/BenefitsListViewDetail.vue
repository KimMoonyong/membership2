<template>

    <v-card outlined>
        <v-card-title>
            BenefitsList # {{$route.params.id }}
        </v-card-title>

        <v-card-text>
            <div>
                <String label="UserId" v-model="item.userId" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="AgreementId" v-model="item.agreementId" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="UserPoint" v-model="item.userPoint" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="AgreePoint" v-model="item.agreePoint" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="AgreementName" v-model="item.agreementName" :editMode="editMode" @change="change" />
            </div>
        </v-card-text>
    </v-card>

</template>

<script>
  const axios = require('axios').default;

  export default {
    name: 'BenefitsListViewDetail',
    props: {
      value: Object,
    },
    data: () => ({
        item : [],
    }),
    async created() {
      var params = this.$route.params;
      var temp = await axios.get(axios.fixUrl('/benefitsLists/' + params.id))

      this.item = temp.data;

    },
    methods: {
    }
  }
</script>

