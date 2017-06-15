const webpack = require('webpack');

const ExtractTextPlugin = require('extract-text-webpack-plugin');
const HtmlWebpackPlugin = require('html-webpack-plugin');
const cssPlugin = new ExtractTextPlugin({
  filename: '[name].bundle.css',
});

module.exports = {

  entry: {
    vendor: [
      'jquery',
      'angular',
      'lodash'
    ],
    main: __dirname + '/src/entries/index.js',
    start: __dirname + '/src/entries/main.js',
    login: __dirname + '/src/entries/login.js',
    homePage: __dirname + '/src/entries/homePage.js',
    hospitalDetail: __dirname + '/src/entries/hospitalDetail.js'
  },
  output: {
    path: __dirname + '/dist',
    filename: '[name].bundle.js'
  },

  //split code
  module: {
    loaders: [{
      test: /\.js$/,
      exclude: /node_modules/,
      loaders: ['babel-loader']
    }, {
      test: /\.html$/,
      use: ['html-loader']
    }, {
      test: /\.css$/,
      use: cssPlugin.extract({
        use: 'css-loader',
        fallback: 'style-loader'
      }),
    }, {
      test: /\.(png)|(gif)|(jpg)$/,
      loader: 'url-loader?limit=50000'
    }, {
      test: /\.woff(2)?(\?v=[0-9]\.[0-9]\.[0-9])?$/,
      use: 'url-loader?limit=10000&mimetype=application/font-woff'
    }, {
      test: /\.(ttf|eot|svg)(\?v=[0-9]\.[0-9]\.[0-9])?$/,
      use: 'file-loader'
    }]
  },

  devServer: {
    inline: true,
    port: 9000,
    proxy: {
      '/api': {
        target: 'http://localhost:8080'
      }
    }
  },

  plugins: [
    new HtmlWebpackPlugin({
      chunks: ['vendor', 'index'],
      filename: __dirname + '/dist/index.html',
      template: './src/entries/index.html'
    }),
    new HtmlWebpackPlugin({
      chunks: ['vendor', 'start'],
      filename: __dirname + '/dist/main.html',
      template: './src/entries/main.html'
    }),
    new HtmlWebpackPlugin({
      chunks: ['vendor', 'login'],
      filename: __dirname + '/dist/login.html',
      template: './src/entries/login.html'
    }),
    new HtmlWebpackPlugin({
      chunks: ['vendor', 'homePage'],
      filename: __dirname + '/dist/homePage.html',
      template: './src/entries/homePage.html'
    }),
    new HtmlWebpackPlugin({
      chunks: ['vendor', 'hospitalDetail'],
      filename: __dirname + '/dist/hospitalDetail.html',
      template: './src/entries/hospitalDetail.html'
    }),
    new webpack.ProvidePlugin({
      $: 'jquery',
      jQuery: 'jquery',
      'window.jQuery': 'jquery',
      'window.jquery': 'jquery'
    }),

    new webpack.optimize.CommonsChunkPlugin({
      name: 'vendor',
      // minChunks: Infinity
    }),
    cssPlugin,
  ]
};