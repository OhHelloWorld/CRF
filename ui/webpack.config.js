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
      'angular-ui-router',
      'lodash'
    ],
    main:__dirname + '/src/entries/index.js',
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
    }]
  },

  plugins: [

    new HtmlWebpackPlugin({
      chunks: ['vendor', 'index'],
      filename: __dirname + '/dist/index.html',
      template: './src/entries/index.html'
    }),
    new webpack.optimize.CommonsChunkPlugin({
      name: 'vendor',
      // minChunks: Infinity
    }),
    cssPlugin,
  ]
};
