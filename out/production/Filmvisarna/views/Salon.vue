<template>
  <div class="salon-container">
    <div class="salon-space"></div>
    <div class="salon-header">
      <h1>VÄLJ DINA PLATSER</h1>
      <div class="seats-icons">
        <div class="seat-available-icon"></div>
        <div class="seat-available">Ledig</div>
        <div class="seat-taken-icon"></div>
        <div class="seat-taken">Ej Ledig</div>
        <div class="seat-chosen-icon"></div>
        <div class="seat-chosen">Vald</div>
      </div>
    </div>

    <div class="salon-space"></div>
    <div class="salon-screen">BIODUK</div>
    <div class="salon-space"></div>

    <div class="grid-container">
      <div class="grid-item">1</div>
      <div class="grid-item">2</div>
      <div class="grid-item">3</div>
      <div class="grid-item">4</div>
      <div class="grid-item">5</div>
      <div class="grid-item">6</div>
      <div class="grid-item">7</div>
      <div class="grid-item">8</div>
      <div class="grid-item">9</div>
      <div class="grid-item">10</div>
      <div class="grid-item">11</div>
      <div class="grid-item">12</div>
      <div class="grid-item">13</div>
      <div class="grid-item">14</div>
      <div class="grid-item">15</div>
      <div class="grid-item">16</div>
      <div class="grid-item">17</div>
      <div class="grid-item">18</div>
      <div class="grid-item">19</div>
      <div class="grid-item">20</div>
      <div class="grid-item">21</div>
      <div class="grid-item">22</div>
      <div class="grid-item">23</div>
      <div class="grid-item">24</div>
      <div class="grid-item">25</div>
      <div class="grid-item">26</div>
      <div class="grid-item">27</div>
      <div class="grid-item">28</div>
      <div class="grid-item">29</div>
      <div class="grid-item">30</div>
      <div class="grid-item">31</div>
      <div class="grid-item">32</div>
      <div class="grid-item">33</div>
      <div class="grid-item">34</div>
      <div class="grid-item">35</div>
      <div class="grid-item">36</div>
      <div class="grid-item">37</div>
      <div class="grid-item">38</div>
      <div class="grid-item">39</div>
      <div class="grid-item">40</div>
      <div class="grid-item">41</div>
      <div class="grid-item">42</div>
      <div class="grid-item">43</div>
      <div class="grid-item">44</div>
      <div class="grid-item">45</div>
      <div class="grid-item">46</div>
      <div class="grid-item">47</div>
      <div class="grid-item">48</div>
      <div class="grid-item">49</div>
      <div class="grid-item">50</div>
      <div class="grid-item">51</div>
      <div class="grid-item">52</div>
      <div class="grid-item">53</div>
      <div class="grid-item">54</div>
      <div class="grid-item">55</div>
      <div class="grid-item">56</div>
      <div class="grid-item">57</div>
      <div class="grid-item">58</div>
      <div class="grid-item">59</div>
      <div class="grid-item">60</div>
      <div class="grid-item">61</div>
      <div class="grid-item">62</div>
      <div class="grid-item">63</div>
      <div class="grid-item">64</div>
      <div class="grid-item">65</div>
      <div class="grid-item">66</div>
      <div class="grid-item">67</div>
      <div class="grid-item">68</div>
      <div class="grid-item">69</div>
      <div class="grid-item">70</div>
      <div class="grid-item">71</div>
      <div class="grid-item">72</div>
      <div class="grid-item">73</div>
      <div class="grid-item">74</div>
      <div class="grid-item">75</div>
      <div class="grid-item">76</div>
      <div class="grid-item">77</div>
      <div class="grid-item">78</div>
      <div class="grid-item">79</div>
      <div class="grid-item">80</div>
      <div class="grid-item">81</div>
      <div class="grid-item">82</div>
      <div class="grid-item">83</div>
      <div class="grid-item">84</div>
      <div class="grid-item">85</div>
      <div class="grid-item">86</div>
      <div class="grid-item">87</div>
      <div class="grid-item">88</div>
      <div class="grid-item">89</div>
      <div class="grid-item">90</div>
      <div class="grid-item">91</div>
      <div class="grid-item">92</div>
      <div class="grid-item">93</div>
      <div class="grid-item">94</div>
      <div class="grid-item">95</div>
      <div class="grid-item">96</div>
      <div class="grid-item">97</div>
      <div class="grid-item">98</div>
      <div class="grid-item">99</div>
      <div class="grid-item">100</div>
    </div>
    <div class="salon-space"></div>
  </div>
</template>






<style scoped>

.salon-header {
  font-family: "Roboto Slab", serif;
  color: white;
  font-weight: 100;
  width: 830px;
  height: 100px;
  background: rgb(0, 0, 0);
  text-align: left;
  margin: 0 auto;
}

.salon-screen {
  width: 830px;
  background: gray;
  color: rgb(255, 255, 255);
  font-family: "Roboto Slab", serif;
  margin: 0 auto;
  height: 30px;
  vertical-align: middle;
  line-height: 30px;
}

.salon-space {
  width: 500px;
  height: 100px;
  background: rgb(0, 0, 0);
  margin: 0 auto;
}
.seats-icons {
  width: 600px;
}

.seat-available-icon {
  float: left;
  width: 20px;
  height: 20px;
  background: rgb(204, 204, 204);
}

.seat-available {
  float: left;
  text-align: left;
  vertical-align: middle;
  line-height: 20px;
  margin-left: 8px;
  width: 70px;
  background: rgb(0, 0, 0); 
}

.seat-taken-icon {
  float: left;
  width: 20px;
  height: 20px;
  background: rgb(93, 93, 93);
}

.seat-taken {
  float: left;
  width: 90px;
  vertical-align: middle;
  line-height: 20px;
  margin-left: 8px;
  background: rgb(0, 0, 0);
}

.seat-chosen-icon {
  float: left;
  width: 20px;
  height: 20px;
  background: rgb(255, 82, 82);
}

.seat-chosen {
  float: left;
  width: 80px;
  vertical-align: middle;
  line-height: 20px;
  margin-left: 8px;
  background: rgb(0, 0, 0);
}

.grid-container {
  display: inline-grid;
  grid-template-columns: repeat(16, 1fr);
  grid-gap: 10px;
}

.grid-item {
  background-color: rgb(204, 204, 204);
  border: 1px solid rgba(0, 0, 0, 0.8);
  font-size: 15px;
  font-weight: bold;
  width: 40px;
  height: 40px;
  text-align: center;
  vertical-align: middle;
  line-height: 40px;
}

.grid-item:hover {
  background-color: rgb(255, 255, 255);
  cursor: pointer;
}

</style>