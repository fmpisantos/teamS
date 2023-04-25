const path = require('path');

module.exports = {
  resolver: {
    extraNodeModules: {
      '@components': path.resolve(__dirname, 'src/components'),
      '@pages': path.resolve(__dirname, 'src/pages'),
    },
  },
  watchFolders: [
    path.resolve(__dirname, 'src'),
    // add any other folders you want to watch for changes here
  ],
};
